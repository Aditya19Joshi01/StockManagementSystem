package com.inventorymgt.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.inventorymgt.dto.CategoryDTO;
import com.inventorymgt.dto.OrderDTO;
import com.inventorymgt.dto.ProductDTO;
import com.inventorymgt.dto.UserDTO;
import com.inventorymgt.exception.RecordNotFoundException;
import com.inventorymgt.form.OrderForm;
import com.inventorymgt.form.ProductForm;
import com.inventorymgt.service.OrderService;
import com.inventorymgt.service.ProductService;
import com.inventorymgt.utility.DataUtility;

@Controller
public class OrderCtl {

	@Autowired
	public OrderService service;

	@Autowired
	public ProductService productService;

	@GetMapping("/order")
	public String order(@ModelAttribute("form") OrderForm form, Model model, HttpSession session) {
		UserDTO user = (UserDTO) session.getAttribute("user");
		List<ProductDTO> list = productService.list();
		model.addAttribute("productList", list);
		model.addAttribute("user", user);
		return "order";
	}

	@PostMapping("/addOrder")
	public String Add(@Valid @ModelAttribute("form") OrderForm form, BindingResult bindingResult, Model model)
			throws IOException {

		System.out.println("form: " + form);
		try {
			if (bindingResult.hasErrors()) {
				System.out.println("bindingResult : " + bindingResult);
				return "order";
			} else {
				OrderDTO bean = form.getDTO();
				ProductDTO pDto = productService.findById(bean.getProductId());
				bean.setProductName(pDto.getName());
				long numberOfUnit = DataUtility.getLong(bean.getNumberOfUnit());
				
				long totalPrice = numberOfUnit * pDto.getPrice();
                model.addAttribute("totalPrice", totalPrice);
                bean.setTotalPrice(totalPrice);
                bean.setStatus("Booked");
				if (pDto.getQuantity() >= numberOfUnit && numberOfUnit>0 ) {

					pDto.setQuantity(pDto.getQuantity() - numberOfUnit);
					productService.update(pDto);
					if (form.getId() > 0) {
						service.update(bean);
						model.addAttribute("success", "Order Updated successfully");
					} else {
						service.Add(bean);
						model.addAttribute("success", "Order Added successfully");
					}
				}else {
					model.addAttribute("error", "Number of unit should be less then available Quantity.");
					return "order";
				}

				return "redirect:/payment";
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "order";
		}
	}

	@GetMapping("/orderList")
	public String list(@ModelAttribute("form") ProductForm form, Model model, HttpSession session) {
		List<OrderDTO> list = null;
		UserDTO uDto = (UserDTO)session.getAttribute("user");
		if(uDto==null) {
			return "redirect:/home";
		}else {

		if(uDto.getUserRole().equals("Admin")) {
			 list = service.list();
		}else {
			list = service.list(uDto.getId());
		}
		
		}
		
		model.addAttribute("list", list);
		return "orderlist";

	}

	@GetMapping("/orderEdit")
	public String update(@ModelAttribute("form") OrderForm form, Model model, @RequestParam("id") long id) {
		OrderDTO bean = service.findById(id);
		form.populate(bean);
		List<ProductDTO> list = productService.list();
		model.addAttribute("productList", list);
		;
		model.addAttribute("bean", bean);
		return "order";
	}

	@GetMapping("/orderDelete")
	public String delete(@ModelAttribute("form") OrderForm form, Model model, @RequestParam("id") long id)
			throws Exception {
		service.delete(id);

		List<OrderDTO> list = service.list();
		model.addAttribute("list", list);
		model.addAttribute("success", "Order Deleted successfully");
		return "orderlist";
	}
	
	@GetMapping("/cancel")
	public String cancel(@ModelAttribute("form") OrderForm form, Model model, @RequestParam("id") long id)
			throws Exception {
		
		OrderDTO oDto = service.findById(id);
		oDto.setStatus("Canceled");
		service.update(oDto);

		List<OrderDTO> list = service.list();
		model.addAttribute("list", list);
		model.addAttribute("success", "Record Updated successfully");
		return "orderlist";
	}

}

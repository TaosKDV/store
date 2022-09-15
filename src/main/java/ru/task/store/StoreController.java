package ru.task.store;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.task.store.data.DiscountsRepository;
import ru.task.store.data.Product;
import ru.task.store.data.ProductRepository;

@RestController
public class StoreController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    DiscountsRepository discountsRepository;

    @RequestMapping("/products/")
    @ResponseBody
    public Iterable<Product> products(HttpServletRequest request) {
        String discount = Optional.ofNullable(request.getParameter("discount")).orElse("");
        if (discount.equals("")) {
            return productRepository.findAll();
        } else {
            Long discountId = discountsRepository.findIdByName(discount);
            return discountId == null ? null : productRepository.findAllByDiscountId(discountId);
        }
    }
}

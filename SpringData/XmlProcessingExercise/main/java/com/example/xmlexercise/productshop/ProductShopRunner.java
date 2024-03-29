package com.example.xmlexercise.productshop;

import com.example.xmlexercise.productshop.entities.products.ExportProductsInRangeDTO;
import com.example.xmlexercise.productshop.entities.users.ExportSellersDTO;
import com.example.xmlexercise.productshop.services.ProductService;
import com.example.xmlexercise.productshop.services.SeedService;
import com.example.xmlexercise.productshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@Component
public class ProductShopRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final ProductService productService;

    private final UserService userService;

    @Autowired
    public ProductShopRunner(SeedService seedService, ProductService productService, UserService userService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
//      this.seedService.seedAll();

//        this.productsInRange();

        this.findUserWithSoldProducts();
    }

    private void findUserWithSoldProducts() throws JAXBException {

        ExportSellersDTO result = this.userService.findAllWithSoldProducts();

        JAXBContext jaxbContext = JAXBContext.newInstance(ExportSellersDTO.class);
        Marshaller marshaller = jaxbContext.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(result, System.out);
    }

    private void productsInRange() throws JAXBException {
        ExportProductsInRangeDTO inRange = this.productService.getInRange(500, 1000);

        JAXBContext context = JAXBContext.newInstance(ExportProductsInRangeDTO.class);

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(inRange, System.out);
    }
}

package com.example.App.sevices;


import com.example.App.entity.Product;
import com.example.App.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }

    public Product saveOrUpdate(Product product) {
        return repository.save(product);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(repository.findAll());
    }

    public ResponseEntity<Product> getProductById(int id) {
        Optional<Product> product = repository.findById(id);

        return product.map(value ->
                ResponseEntity.ok().body(value)).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    public ResponseEntity<Map<String, Object>> findProductsByCategory(int page, int size, String category) {

        try {
            List<Product> products;
            Pageable paging = PageRequest.of(page, size);

            Page<Product> pageProds = repository.findByCategory(category, paging);
            products = pageProds.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("products", products);
            response.put("currentPage", pageProds.getNumber());
            response.put("totalItems", pageProds.getTotalElements());
            response.put("totalPages", pageProds.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void deleteProduct(int id) {
        repository.deleteById(id);
    }
}

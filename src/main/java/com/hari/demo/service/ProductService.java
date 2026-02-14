package com.hari.demo.service;

import com.hari.demo.model.Product;
import com.hari.demo.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

        @Autowired
        private ProductRepository productRepository;

        @PostConstruct
        public void init() {
                long count = productRepository.count();

                // FORCE UPDATE: If we have the old set (~40 items) or less, we wipe and re-seed
                // to fix images.
                if (count < 60) {
                        System.out.println("Catalog count (" + count
                                        + ") is low or old. Wiping to re-seed with fresh images...");
                        productRepository.deleteAll();

                        List<Product> products = Arrays.asList(
                                        // ELECTRONICS
                                        new Product("Premium Wireless Headphones", 299.99,
                                                        "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?auto=format&fit=crop&w=800",
                                                        "Electronics"),
                                        new Product("Mechanical Keyboard", 149.99,
                                                        "https://images.unsplash.com/photo-1587829741301-308231c8ad46?auto=format&fit=crop&w=800",
                                                        "Electronics"),
                                        new Product("Smart Speaker", 79.99,
                                                        "https://images.unsplash.com/photo-1589492477829-5e65395b66cc?auto=format&fit=crop&w=800",
                                                        "Electronics"),
                                        new Product("4K Monitor", 399.00,
                                                        "https://images.unsplash.com/photo-1527443224154-c4a3942d3acf?auto=format&fit=crop&w=800",
                                                        "Electronics"),
                                        new Product("Gaming Mouse", 59.99,
                                                        "https://images.unsplash.com/photo-1527864550417-7fd91fc51a46?auto=format&fit=crop&w=800",
                                                        "Electronics"),
                                        new Product("Laptop Stand", 45.00,
                                                        "https://images.unsplash.com/photo-1616348436168-de43ad0db179?auto=format&fit=crop&w=800",
                                                        "Electronics"),
                                        new Product("Noise Cancelling Earbuds", 199.99,
                                                        "https://images.unsplash.com/photo-1590658268037-6bf12165a8df?auto=format&fit=crop&w=800",
                                                        "Electronics"),
                                        new Product("Portable Charger", 29.99,
                                                        "https://images.unsplash.com/photo-1622445275576-721325763afe?auto=format&fit=crop&w=800",
                                                        "Electronics"),
                                        new Product("Wireless Charger", 39.99,
                                                        "https://images.unsplash.com/photo-1615526675619-38b4dd30824b?auto=format&fit=crop&w=800",
                                                        "Electronics"),
                                        new Product("Action Camera", 249.00,
                                                        "https://images.unsplash.com/photo-1564466013-40ae05aa9c73?auto=format&fit=crop&w=800",
                                                        "Electronics"),

                                        // FASHION
                                        new Product("Classic Denim Jacket", 89.99,
                                                        "https://images.unsplash.com/photo-1523205771623-e0faa4d2813d?auto=format&fit=crop&w=800",
                                                        "Fashion"),
                                        new Product("Cotton T-Shirt", 29.50,
                                                        "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?auto=format&fit=crop&w=800",
                                                        "Fashion"),
                                        new Product("Summer Floral Dress", 69.00,
                                                        "https://images.unsplash.com/photo-1515372039744-b8f02a3ae446?auto=format&fit=crop&w=800",
                                                        "Fashion"),
                                        new Product("Leather Boots", 159.00,
                                                        "https://images.unsplash.com/photo-1608256246200-53e635b5b69f?auto=format&fit=crop&w=800",
                                                        "Fashion"),
                                        new Product("Running Shoes", 110.00,
                                                        "https://images.unsplash.com/photo-1542291026-7eec264c27ff?auto=format&fit=crop&w=800",
                                                        "Fashion"),
                                        new Product("Casual Hoodie", 49.99,
                                                        "https://images.unsplash.com/photo-1556906781-9a412961d28c?auto=format&fit=crop&w=800",
                                                        "Fashion"),
                                        new Product("Formal Blazer", 129.00,
                                                        "https://images.unsplash.com/photo-1507679799987-c73779587ccf?auto=format&fit=crop&w=800",
                                                        "Fashion"),
                                        new Product("Silk Scarf", 35.00,
                                                        "https://images.unsplash.com/photo-1601369796030-c3d5964f9b8c?auto=format&fit=crop&w=800",
                                                        "Fashion"),
                                        new Product("Slim Fit Jeans", 59.90,
                                                        "https://images.unsplash.com/photo-1541099649105-f69ad21f3246?auto=format&fit=crop&w=800",
                                                        "Fashion"),
                                        new Product("Leather Jacket", 299.00,
                                                        "https://images.unsplash.com/photo-1487222477894-8943e31ef7b2?auto=format&fit=crop&w=800",
                                                        "Fashion"),

                                        // ACCESSORIES
                                        new Product("Minimalist Watch", 129.50,
                                                        "https://images.unsplash.com/photo-1524805444758-089113d48a6d?auto=format&fit=crop&w=800",
                                                        "Accessories"),
                                        new Product("Designer Sunglasses", 159.00,
                                                        "https://images.unsplash.com/photo-1572635196237-14b3f281503f?auto=format&fit=crop&w=800",
                                                        "Accessories"),
                                        new Product("Leather Wallet", 49.99,
                                                        "https://images.unsplash.com/photo-1627123424574-181ce5171c98?auto=format&fit=crop&w=800",
                                                        "Accessories"),
                                        new Product("Canvas Backpack", 79.00,
                                                        "https://images.unsplash.com/photo-1553062407-98eeb64c6a62?auto=format&fit=crop&w=800",
                                                        "Accessories"),
                                        new Product("Silver Necklace", 89.00,
                                                        "https://images.unsplash.com/photo-1599643478518-17488fbbcd75?auto=format&fit=crop&w=800",
                                                        "Accessories"),
                                        new Product("Gold Earrings", 120.00,
                                                        "https://images.unsplash.com/photo-1535632066927-ab7c9ab60908?auto=format&fit=crop&w=800",
                                                        "Accessories"),
                                        new Product("Travel Bag", 150.00,
                                                        "https://images.unsplash.com/photo-1566838320490-3a4a814cb2c0?auto=format&fit=crop&w=800",
                                                        "Accessories"),
                                        new Product("Beanie Hat", 25.00,
                                                        "https://images.unsplash.com/photo-1576871337622-98d48d1cf531?auto=format&fit=crop&w=800",
                                                        "Accessories"),

                                        // HOME & FURNITURE (Fixed Images)
                                        new Product("Ergonomic Office Chair", 199.00,
                                                        "https://images.unsplash.com/photo-1519947486511-46149fa0a254?auto=format&fit=crop&w=800",
                                                        "Furniture"),
                                        new Product("Modern Coffee Table", 149.00,
                                                        "https://images.unsplash.com/photo-1532372320572-cda25653a26d?auto=format&fit=crop&w=800",
                                                        "Furniture"),
                                        new Product("Ceramic Vase", 35.00,
                                                        "https://images.unsplash.com/photo-1578500494198-246f612d3b3d?auto=format&fit=crop&w=800",
                                                        "Home"),
                                        new Product("Soft Throw Blanket", 45.00,
                                                        "https://images.unsplash.com/photo-1596468138865-cbe298414578?auto=format&fit=crop&w=800",
                                                        "Home"),
                                        new Product("Table Lamp", 55.00,
                                                        "https://images.unsplash.com/photo-1507473888900-52e1adad54cd?auto=format&fit=crop&w=800",
                                                        "Home"),
                                        new Product("Wall Clock", 39.99,
                                                        "https://images.unsplash.com/photo-1563861826100-9cb868c621cb?auto=format&fit=crop&w=800",
                                                        "Home"),
                                        new Product("Plant Pot", 25.00,
                                                        "https://images.unsplash.com/photo-1485955900006-10f4d324d411?auto=format&fit=crop&w=800",
                                                        "Home"),
                                        new Product("Decorative Pillow", 29.00,
                                                        "https://images.unsplash.com/photo-1579656381226-5fc7036586d3?auto=format&fit=crop&w=800",
                                                        "Home"),

                                        // WEARABLES
                                        new Product("Smart Fitness Tracker", 89.99,
                                                        "https://images.unsplash.com/photo-1575311373937-040b8e1fd5b6?auto=format&fit=crop&w=800",
                                                        "Wearables"),
                                        new Product("Pro Smartwatch", 249.00,
                                                        "https://images.unsplash.com/photo-1544117519-31a4b719223d?auto=format&fit=crop&w=800",
                                                        "Wearables"),
                                        new Product("VR Headset", 399.00,
                                                        "https://images.unsplash.com/photo-1622979135225-d2ba269fb1bd?auto=format&fit=crop&w=800",
                                                        "Wearables"));
                        productRepository.saveAll(products);
                        System.out.println("Seeded product database with FIXED images.");
                }
        }

        public List<Product> findAll() {
                return productRepository.findAll();
        }

        public Optional<Product> findById(Long id) {
                return productRepository.findById(id);
        }

        public Product save(Product product) {
                return productRepository.save(product);
        }

        public void deleteById(Long id) {
                productRepository.deleteById(id);
        }
}

package com.shopsphere.shopsphere.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
/* This tells Spring & JPA:
> “This class is a database **entity**. Create a table for it.”

- It maps the **Java class** to a **table** in your database.
- By default, the table name will be the **same as the class** (`product`).
- Each field becomes a column in the table.

✅ This is required for Hibernate to manage the object ↔ SQL mapping.
 */

@Data

@NoArgsConstructor
@AllArgsConstructor

/* Annotation        Required?        Reason
@NoArgsConstructor   ✅ Required      Hibernate needs it to construct the entity
@AllArgsConstructor  ❌ Optional      Just for your coding convenience (tests, seeds)
*/

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;
    private int stock;
}

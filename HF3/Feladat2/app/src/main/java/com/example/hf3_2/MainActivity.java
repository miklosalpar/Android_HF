package com.example.hf3_2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editProductCode, editProductName, editProductPrice;
    private Button btnAddProduct, btnCancel, btnShowProducts;
    private TextView textViewOutput;

    private List<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editProductCode = findViewById(R.id.edit_product_code);
        editProductName = findViewById(R.id.edit_product_name);
        editProductPrice = findViewById(R.id.edit_product_price);
        btnAddProduct = findViewById(R.id.btn_add_product);
        btnCancel = findViewById(R.id.btn_cancel);
        btnShowProducts = findViewById(R.id.btn_show_products);
        textViewOutput = findViewById(R.id.textview_output);

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProduct();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });

        btnShowProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProducts();
            }
        });
    }

    private void addProduct() {
        String code = editProductCode.getText().toString().trim();
        String name = editProductName.getText().toString().trim();
        String priceStr = editProductPrice.getText().toString().trim();

        if (code.isEmpty() || name.isEmpty() || priceStr.isEmpty()) {
            Toast.makeText(this, "Kérjük, töltse ki az összes mezőt!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double price = Double.parseDouble(priceStr);
            Product newProduct = new Product(code, name, price);
            productList.add(newProduct);

            Toast.makeText(this, "Termék hozzáadva: " + name, Toast.LENGTH_SHORT).show();
            clearFields();

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Az árnak érvényes számnak kell lennie!", Toast.LENGTH_LONG).show();
        }
    }

    private void clearFields() {
        editProductCode.setText("");
        editProductName.setText("");
        editProductPrice.setText("");
    }


    private void showProducts() {
        if (productList.isEmpty()) {
            textViewOutput.setText("Nincs tárolt termék.");
            return;
        }

        StringBuilder sb = new StringBuilder("Összes termék (" + productList.size() + " db):\n\n");
        for (Product product : productList) {
            sb.append(product.toString());
        }

        textViewOutput.setText(sb.toString());
    }
}
package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecipeAdapter.OnItemClickListener {

    private List<Recipe> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set the title for the activity
            setTitle("Recycler View");
        // Create a list of recipes
        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(new Recipe("Kale/Lemon Sandwiches", "This sandwiches is stunningly delicious and tastes as good as it is healthy .Any greens of choice ill work.The lemon adds an almost sweet taste.Be generous with it !"));
        recipeList.add(new Recipe("Mango-Lime Bean Salad", "Everyone loves this, so double or even triple the recipe! It vanishes in a flash, and also works well as a salsa. It really is our all-time favorite summer salad. "));
        recipeList.add(new Recipe("Sweet Potato and Lentil Soup with Shiitake Mushrooms", "This soup is so good Easy and I ate it All the first time I made it. If someone is hesitant about plant-based food, this has to be a convincer"));
        recipeList.add(new Recipe("Lime Mousse", "This s FABULOUS alone, topped with fruit of any kind or as a frosting on cake. It is fast to make at the last minute. Use more or less lime according to taste."));
        recipeList.add(new Recipe("Broiled Tilapia Parmsan", "Broiled Tilapia Parmesan is a delectable and flavorful dish that features tender tilapia fillets coated with a savory Parmesan and herb crust. This recipe combines the mildness of tilapia with the richness of Parmesan cheese, creating a delightful harmony of textures and tastes. "));
        recipeList.add(new Recipe("Pancake", "Fluffy, golden-brown pancakes, a timeless breakfast classic that never fails to evoke a sense of comfort and warmth. These pancakes are a testament to simplicity and deliciousness, embodying the perfect balance of softness and slight crispiness around the edges."));
        recipeList.add(new Recipe("Scrambled Eggs", "Scrambled eggs, a culinary classic that transforms humble ingredients into a dish of comforting simplicity and unmatched versatility. The art of creating perfect scrambled eggs lies in achieving the delicate balance of fluffy texture, rich flavor, and just the right degree of creaminess."));

        // Add more recipes as needed

        // Create RecyclerView and set adapter
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecipeAdapter adapter = new RecipeAdapter(recipeList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClick(int position) {
        // Handle item click, start RecipeActivity
        Intent intent = new Intent(this, RecipeActivity.class);
        intent.putExtra("title", recipeList.get(position).getTitle());
        intent.putExtra("description", recipeList.get(position).getDescription());
        startActivity(intent);
    }
}

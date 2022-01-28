package hu.ibello.demo.model;

import hu.ibello.core.Description;
import hu.ibello.data.Model;

import static hu.ibello.demo.model.ProductNames.*;

@Model
@Description("Test data choose product to order")
public class ProductToOrder {

    private int evaluation;
    private int server;
    private int analyzer;
    private int creator;

    @Description("It is used to identify testdata.")
    private String id;

    public int getEvaluation() {
        return evaluation;
    }

    public int getServer() {
        return server;
    }

    public int getAnalyzer() {
        return analyzer;
    }

    public int getCreator() {
        return creator;
    }

    @Override
    public String toString() {
        if (id != null) {
            return id;
        }
        return "No given id";
    }
}

package com.gmail.l.domelink;

import java.io.*;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet (name = "JsonServlet", urlPatterns = {"/json_result"})
public class JsonServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String json = req.getParameter("text");
        Gson gson = new GsonBuilder().create();
        Library lib = gson.fromJson(json, Library.class);
        resp.getWriter().println(lib);

    }

    public class Book {
        String name;
        double price;

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
    public class Library {
        Book [] books;
        String shop;

        @Override
        public String toString() {
            return "Library{" +
                    "books=" + Arrays.toString(books) +
                    ", shop='" + shop + '\'' +
                    '}';
        }
    }
}
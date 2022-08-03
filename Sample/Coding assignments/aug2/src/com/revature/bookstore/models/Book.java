package com.revature.bookstore.models;

import com.revature.bookstore.exceptions.InvalidPriceException;

public class Book {
private String bookName;
private String author;
private String category;
private int price;

public void Boook()
{
this.bookName=bookName;
this.author=author;
this.category=category;
this .price=price;
}

public String getBookName(String bookName,String author,String category,int price) {
	return bookName;
}
public void setPrice(int price)


if(price< 100 || price >200 )throw new InvalidPriceException(message:"Invalid Amount:PLease put entr 100 - 200");
this.price=price;

}

public void setBookName(String bookName) {
	this.bookName = bookName; 
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public int getPrice() {
	return price;
}



@Override
public String toString() {
	return "Book [bookName=" + bookName + ", author=" + author + ", category=" + category + ", price=" + price + "]";
}

}

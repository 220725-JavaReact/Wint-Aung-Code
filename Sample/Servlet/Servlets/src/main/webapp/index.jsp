<%@page import="com.revature.model.*"%>
<%@page language ="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%
Customer auth=(Customer)request.getSession().getAttribute("auth")
if(Customer!=null)
{
    request.setAttribut("auth" ,auth);
}

%>
<!DOCTYPE html>

<html>
    <head>
        <title>Welcome to Shopping Cart!</title>
        

    </head>
    <body>

        <div class="container">
        <div class="card-header my-3">All Products</div>
        <div class="row">
            <div class="col-md-3">
               <div class="card-body">
                <h5 class="card-title">Cart Title</h5>
                <h6 class="Price">Price: $452</h6>
                <h6 class="Category" >Category: some Category</h6>
                <div class="mt-3-flex_justify-content-between">
                    <a href="#" class="btn btn-primary">Add to Cart</a>
                    <a href="#" class="btn btn-primary">Buy Now</a>
                </div>
                
               </div> 
            </div>
        </div>
        </div>
    </body>
</html>
<#include "macros/main.ftl">

<@layout _title="Cart" _page="cart">

<div class="container">
    <table class="table adminTable">
    <legend>Cart</legend>
        <tr>
            <th>Product</th>
            <th>Amount</th>
            <th></th>
        </tr>
        <#list cartItemList as item>
            <tr>
                <td>${item.product.name}</td>
                <td>${item.quantity}</td>
                <td>
                    <a href="/deleteFromCart-${item_index}">
                        <button class="btn btn-danger">Delete from cart</button>
                    </a>
                </td>
            </tr>
        </#list>
    </table>
    <a href="/addOrder">
        <button class="btn btn-success">Order</button>
    </a>
    <a href="/clearCart">
        <button class="btn btn-danger">Clear cart</button>
    </a>
</div>

</@layout>
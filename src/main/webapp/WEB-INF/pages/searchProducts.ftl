<#include "macros/main.ftl">
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<@layout _title="Strona glowna" _page="products">


<#--Strona najwazniejsza-->

<div class="container">

    <!-- Example row of columns -->
    <div class="row">

        <div class="span3">
            <@displayCategories _header="All"/>
        </div>

        <div class="span9">
            <!-- Main hero unit for a primary marketing name or call to action -->
            <#assign displayNextPage = false/>
            <div class="row">
                <ul id="products" class="thumbnails">
                    <#list productListPage as product>
                            <li class="span3">
                                <div class="thumbnail box">
                                    <div class="caption">
                                        <h3>${product.name}</h3>
                                        <ul style="list-style: none">
                                            <li class="productspecifications pull-left text-info">Quantity:</li>
                                            <li class="productsvalues pull-right">${product.quantity}</li>
                                            <br>

                                            <div class="topPadding">
                                                <li class="productspecifications pull-left text-info">Price</li>
                                                <li style="font-size: 25}" class="productsvalues pull-right">${product.price}</li>
                                            </div>
                                            <br>

                                            <form action="/addToCart-${product.id}-${headerCategory}-${parentId}-${pageSize}" method="POST">

                                                <div class="topPadding">
                                                    <li class="productspecifications pull-left text-info">Amount</li>
                                                    <input type="text" value="1" class="span1 pull-right" name="amount" id="amount" style="text-align: right; width: 40px"><br><br>
                                                </div>

                                                <button id="mainButton" type="submit" class="btn btn-primary pull-right">Buy</button>
                                            </form>
                                            <br />
                                        </ul>
                                    </div>
                                </div>
                            </li>
                    </#list>
                </ul>
            </div>
        </div>
    </div>
</div>

<#--strona najwazniejsza-->
</@layout>
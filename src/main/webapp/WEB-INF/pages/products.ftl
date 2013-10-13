<#include "macros/main.ftl">
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<#--Odpowiada za prawidlowe wyswietlanie-->
<#assign maxSizePage = 6/>
<@layout _title="Strona glowna" _page="products">

<head>
    <style type="text/css">
        .thumbnails#products > li {
            margin-left: 40px;
        }

        .box{
            border: 1px solid purple;
            border-radius: 10px;
            background-image: -webkit-gradient(linear, center top, center bottom, from(#fcfcfc), to(#bfbfbf), color-stop(3%, #f7f7f7), color-stop(12%, #f2f2f2), color-stop(90%, #d9d9d9));
            background-image: -webkit-linear-gradient(top, #fcfcfc, #f7f7f7 3%, #f2f2f2 12%, #d9d9d9 90%, #bfbfbf);
            background-image: -moz-linear-gradient(top, #fcfcfc, #f7f7f7 3%, #f2f2f2 12%, #d9d9d9 90%, #bfbfbf);
            background-image: -o-linear-gradient(top, #fcfcfc, #f7f7f7 3%, #f2f2f2 12%, #d9d9d9 90%, #bfbfbf);
            background-image: -ms-linear-gradient(top, #fcfcfc, #f7f7f7 3%, #f2f2f2 12%, #d9d9d9 90%, #bfbfbf);
            background-image: linear-gradient(to bottom, #fcfcfc, #f7f7f7 3%, #f2f2f2 12%, #d9d9d9 90%, #bfbfbf);
            -webkit-box-shadow: 0 1px 5px rgba(0,0,0,0.75), inset 0 1px 15px maroon;
            -moz-box-shadow: 0 1px 5px rgba(0,0,0,0.75), inset 0 1px 15px maroon;
            box-shadow: 0 1px 5px rgba(0,0,0,0.75), inset 0 1px 15px maroon;
            padding-bottom: 12px;
        }

        .topPadding{
            padding-top: 5px;
        }

        .productspecifications{
            color: maroon;
            font-size: 17px;
        }
        .productsvalues{
            font-size: 25px;
            color: goldenrod;
        }

    </style>

</head>

<#--Strona najwazniejsza-->

<div class="container">

    <!-- Example row of columns -->
    <div class="row">

        <div class="span3">
            <@displayCategories _header=headerCategory/>
        </div>

        <div class="span9">
            <!-- Main hero unit for a primary marketing name or call to action -->
            <#assign displayNextPage = false/>
            <div class="row">
                <ul id="products" class="thumbnails">
                    <#list productListPage as product>
                        <#if product_index = maxSizePage>
                            <#assign displayNextPage = true/>
                        <#else>
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
                        </#if>
                    </#list>
                </ul>
            </div>

            <#--displaying next/previous buttons-->

            <div class="span9">
                <div class="pagination-centered">
                    <a type="buttons"
                       class="btn btn-mini
                            <#if pageSize = 0> disabled"
                            <#else>" href="/displayProducts-${headerCategory}-${parentId}-${pageSize-maxSizePage}"
                            </#if>>
                       Previous
                    </a>

                    <a type="buttons"
                        class="btn btn-mini
                            <#if displayNextPage = false> disabled"
                            <#else>" href="/displayProducts-${headerCategory}-${parentId}-${pageSize+maxSizePage}"
                            </#if>>
                        Next
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<#--strona najwazniejsza-->
</@layout>



<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#--macra dla stron glownych-->


<#--MAIN LAYOUT MACRO INCLUDES MACROS ABOVE-->

<#macro layout _title _page>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <@head title=_title/>

    <style type="text/css">
        body#borderLayout {
            /*background: -moz-linear-gradient(left, #CB1E19, #E8BFAB 10%, white 30%, white 70%, #E8BFAB 80%,  #CB1E19);*/

            /*background: -moz-linear-gradient(left,black, rgb(53, 7, 0) 3%, rgb(171,0,0) 10%, white 30%, white 70%, rgb(171,0,0) 90%,  rgb(53, 7, 0) 97%, black);*/
        }

        .nav-header#goldenmenuheader{
            /*color: darkgoldenrod;*/
        }
        .thumbnail#goldenmenu{
            /*border: 1px solid darkgoldenrod;"*/
        }

        .nav#menu > li > a:hover {
            /*background: maroon;*/
            /*color: gold;*/
        }
        .nav#menu > li > a {
            /*color: lightsalmon;*/
        }
        .btn-primary#mainButton{
            background-color: #006dcc;
            color: goldenrod;
            background-image: -moz-linear-gradient(top, maroon, black);
            background-image: -webkit-gradient(linear, 0 0, 0 100%, from(maroon), to(black));
            background-image: -webkit-linear-gradient(top, maroon, black);
            background-image: -o-linear-gradient(top, maroon, black);
            background-image: linear-gradient(to top, black, maroon);
            background-repeat: repeat-x;
            border-color: maroon maroon maroon;
        }
        .btn-primary#mainButton:hover,
        .btn-primary#mainButton:focus{
            background: maroon;
            color: goldenrod;
            background-image: -moz-linear-gradient(top, black, maroon);
            background-image: -webkit-gradient(linear, 0 0, 0 100%, from(black), to(maroon));
            background-image: -webkit-linear-gradient(top, black, maroon);
            background-image: -o-linear-gradient(top, black, maroon);
            background-image: linear-gradient(to top, maroon, black);
            background-repeat: repeat-x;
            border-color: maroon maroon maroon;
        }
        .btn-primary#mainButton.active{
            color: goldenrod;
        }

        <#--admin panel-->
        .adminTabs > li.active > a:hover,
        .adminTabs > li.active > a:focus,
        .adminTabs > li.active > a
        {
            /*background-color: maroon;*/
            /*color: goldenrod;*/
            /*border: none;*/
        }
        .adminTabs > li > a{
            /*color: maroon;*/
            /*font-size: 20px;*/
        }
        .adminTabs > li > a:focus,
        .adminTabs > li > a:hover{
            /*background-color: maroon;*/
            /*color: goldenrod;*/
            /*border: none;*/
        }
        .nav-tabs#adminTabs {
            /*border-bottom: 1px solid goldenrod;;*/
        }

        legend.adminLegend{
            /*color: orange;*/
            /*border-bottom: 1px solid darkgoldenrod;*/
        }

        .adminTable tr{
            /*color: orange;*/
        }

        .adminTable tbody tr > th {
            border-top: none;
        }
        .adminTable tbody tr > td{
            /*border-top: 1px solid darkgoldenrod;*/
        }

        .adminTable tbody tr:hover > td,
        .adminTable tbody tr:hover > th{
            /*background: maroon;*/
            /*color: goldenrod;*/
        }

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


<body id="borderLayout">

    <@top page=_page/>

    <#--Strona wlasciwa-->
     <#nested>
    <#--koniec strona wlasciwa-->

    <#--start footer-->

    <@footer/>

    <#--end footer-->

</body>
</html>
</#macro>


<#--END MAIN LAYOUT MACRO-->






<#--header macro-->
<#macro head title>

<meta charset="utf-8">
<title>${title}</title>

<style type="text/css">
            <#include "../assets/css/bootstrap.css">
            <#include "../assets/css/docs.css">
            <#include "../assets/css/bootstrap-responsive.css">
        </style>




<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>

<script type="text/javascript">
            <#include "../assets/js/bootstrap.min.js">
            <#include "../assets/js/bootstrap-carousel.js">
            <#include "../assets/js/application.js">
            <#include "../assets/js/bootstrap-affix.js">
            <#include "../assets/js/bootstrap-alert.js">
            <#include "../assets/js/bootstrap-button.js">
            <#include "../assets/js/bootstrap-collapse.js">
            <#include "../assets/js/bootstrap-dropdown.js">
            <#include "../assets/js/bootstrap-modal.js">
            <#include "../assets/js/bootstrap-popover.js">
            <#include "../assets/js/bootstrap-scrollspy.js">
            <#include "../assets/js/bootstrap-tab.js">
            <#include "../assets/js/bootstrap-tooltip.js">
            <#include "../assets/js/bootstrap-transition.js">
            <#include "../assets/js/bootstrap-typeahead.js">
        </script>

</#macro>

<#--end heading macro-->


<#--top macro-->
<#macro top page>

<head>
    <style type="text/css" >
         .navbar-inner {
            background: #aa00ba; /* Old browsers */
            background: -moz-linear-gradient(left,  #aa00ba 0%, #a44dbc 27%, #cda7d1 82%); /* FF3.6+ */
            background: -webkit-gradient(linear, left top, right top, color-stop(0%,#aa00ba), color-stop(27%,#a44dbc), color-stop(82%,#cda7d1)); /* Chrome,Safari4+ */
            background: -webkit-linear-gradient(left,  #aa00ba 0%,#a44dbc 27%,#cda7d1 82%); /* Chrome10+,Safari5.1+ */
            background: -o-linear-gradient(left,  #aa00ba 0%,#a44dbc 27%,#cda7d1 82%); /* Opera 11.10+ */
            background: -ms-linear-gradient(left,  #aa00ba 0%,#a44dbc 27%,#cda7d1 82%); /* IE10+ */
            background: linear-gradient(to right,  #aa00ba 0%,#a44dbc 27%,#cda7d1 82%); /* W3C */
            border-color: purple;
            border: 1px;
        }

        .brand{
            text-decoration: none;
            text-shadow: 0 1px 0 rgba(255, 255, 255, 0.1), 0 0 30px rgba(0, 0, 0, 0.125);
        }

        .navbar .brand:hover{
            text-decoration: none;
            text-shadow: 0 1px 0 rgba(255, 255, 255, 0.1), 0 0 30px rgba(170, 0, 186, 0.125);
        }
    </style>
</head>

<div id="mynavbar" class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="/">BussinesShop</a>

            <div class="nav-collapse collapse">
                <ul class="nav">

                    <li <#if page == "home">class="active"</#if>><a href="/">Home</a></li>
                    <li <#if page == "about">class="active"</#if>><a href="/about.ftl">About</a></li>
                    <li <#if page == "contact">class="active"</#if>><a href="/contact.ftl">Contact</a></li>
                    <@security.authorize access="isAnonymous()">
                        <li <#if page == "register">class="active"</#if>><a href="/register.ftl">Register</a></li>
                    </@security.authorize>
                    <@security.authorize ifAnyGranted="ROLE_ADMIN">
                        <li <#if page == "admin">class="active"</#if>><a href="/admin/usersTab.ftl">AdminPanel</a></li>
                    </@security.authorize>

                </ul>
                <@security.authorize access="isAnonymous()">
                    <form class="navbar-form pull-right" action="j_spring_security_check" method="post">
                        <input id="username" name="j_username" class="span2" type="text" placeholder="Login" width="70">
                        <input id="password" name="j_password" class="span2" type="password" placeholder="Password"
                               width="70">
                        <button type="submit" class="btn">Sign in</button>
                    </form>
                </@security.authorize>
                <@security.authorize access="isAuthenticated()">
                    <a class="btn pull-right" href="/j_spring_security_logout">Logout &raquo;</a>
                    <a href="/cart">
                        <input type="image" src="http://blink.ucsd.edu/_images/faculty-tab/Shopping-Cart.png"
                                            class="pull-right"
                                            style="height: 40px; padding-right: 15px">
                    </a>

                    <form action="/searchProducts" class="navbar-search pull-right" style="padding-right: 30px">
                        <input name="searcher" type="text" class="search-query" placeholder="Search" style="height: 30">
                    </form>
                </@security.authorize>
            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>

</#macro>
<#--end top macro-->


<#--macro footer-->
<#macro footer>

<div class="container">
    <footer id="footer">
        <br>

        <p class="pull-left">Copyright by BestTeam</p>
    </footer>
</div>

</#macro>
<#--end macro footer-->


<#--categories display macro-->
<#macro displayCategories _header>
<div id="goldenmenu" class="thumbnail">
    <ul id="menu" class="nav nav-list">
        <li><label id="goldenmenuheader" class="tree-toggle nav-header">${_header}</label></li>
        <#list categoryListCore as cat>
            <li>
                <a href="displayProducts-${cat.name}-${cat.id}-0">${cat.name}</a>
            </li>
        </#list>
        <#if previousCategory??>
            <li><a class="btn btn-mini" href="/displayProducts-${previousCategory.name}-${previousCategory.id}-0">Back</a></li>
        <#else>
            <li><a class="btn btn-mini" href="/">Back</a></li>
        </#if>
    </ul>


</div>
</#macro>
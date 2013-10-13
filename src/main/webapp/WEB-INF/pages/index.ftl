<#include "macros/main.ftl">

<@layout _title="Strona glowna" _page="home">


<#--Strona najwazniejsza-->

<div class="container">

    <head>
        <style type="text/css">
            .hero-unit{
                background-image:url('http://www.tapetus.pl/obrazki/n/178403_nuty-grafika-abstrakcja.jpg');
                background-repeat: no-repeat;
                background-size: 870px 270px;
                height: 150px;
            }

            h1.herotext,
            h2.herotext{
                color: darkgoldenrod;
                font-family: "monotype corsiva", helvetica, Arial, sens-serif;
                color:
            }
        </style>
    </head>

    <!-- Example row of columns -->
    <div class="row">

        <div class="span3">
            <@displayCategories _header="All"/>
        </div>

        <div class="span9">
            <!-- Main hero unit for a primary marketing name or call to action -->
            <div class="hero-unit">
                <h1 class="herotext">Welcome in Music World</h1>

                <h2 class="herotext">Check our products right now</h2>

                <p><a id="mainButton" class="btn btn-primary pull-right btn-large" href="#">Learn more &raquo;</a></p>
            </div>

            <!-- Example row of columns -->
            <div class="row">
                <div class="span3">
                    <div class="thumbnail">
                        <h2>ADVERTISING</h2>

                        <p>HERE IS A PLACE TO YOUR ADVERTISING</p>

                        <p><a class="btn" href="#">View details &raquo;</a></p>
                    </div>
                </div>
                <div class="span3">
                    <div class="thumbnail">
                        <h2>ADVERTISING</h2>

                        <p>HERE IS A PLACE TO YOUR ADVERTISING</p>

                        <p><a class="btn" href="#">View details &raquo;</a></p>
                    </div>
                </div>
                <div class="span3">
                    <div class="thumbnail">
                        <h2>ADVERTISING</h2>

                        <p>HERE IS A PLACE TO YOUR ADVERTISING</p>

                        <p><a class="btn" href="#">View details &raquo;</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<#--strona najwazniejsza-->
</@layout>

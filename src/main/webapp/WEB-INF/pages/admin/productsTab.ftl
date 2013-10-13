<#include "../macros/main.ftl">
<#include "../macros/admin.ftl">

<@layout _title="Admin panel" _page="admin">
    <@adminPanelTabs tab="products">
        <@addProductForm/>
        <@productList/>
    </@adminPanelTabs>
</@layout>
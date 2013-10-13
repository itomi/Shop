<#include "../macros/main.ftl">
<#include "../macros/admin.ftl">

<@layout _title="Admin panel" _page="admin">

    <@adminPanelTabs tab="categories">
        <@addCategoryForm/>
        <@categoryList _header="All"/>
    </@adminPanelTabs>

</@layout>
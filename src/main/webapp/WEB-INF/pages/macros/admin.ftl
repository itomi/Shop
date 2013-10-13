<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#import "/spring.ftl" as spring />

<#macro userList>

<head>
    <style type="text/css">
        .control-group {
            margin-bottom: 1px;
        }
    </style>
</head>
<#--potrzebna lista userów-->
<legend class="adminLegend">User List</legend>
<table class="adminTable table table-hover">
    <tr>
        <th>Username</th>
        <th>E-mail</th>
        <th>Enabled</th>
        <th>Authority</th>
    </tr>
    <#list userListCore as user>
        <tr>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.enabled?string("Enabled","Disabled")}</td>
            <td>${user.authority.authority}</td>

        <#--@TODO: dopisać zabezpieczenia-->

            <td>
                <a class="btn btn-default" href="/admin/userDetails-${user.username}"> User details </a>
                <a class="btn btn-danger" href="/admin/deleteUser-${user.username}"> Delete user! </a>
            </td>
        </tr>
    </#list>
</table>
</fieldset>
</#macro>

<#macro userDetails>

    <head>
    <style type="text/css">
        .control-group {
            margin-bottom: 1px;
        }
    </style>
</head>

    <div class="container">
    <form id="userDetails" class="form-group" method="post" action="changeUserDetails">
        <legend>View or edit User details</legend>
        <input type="hidden" value="${user.id}" name="id"/>

    <#--login-->
        <div class="control-group">
            <label class="control-label">Login</label>

            <div class="controls">
                <input type="text" class="input-xlarge"
                       value="${user.username}" readonly="readonly" name="username"
                       placeholder="Username" style="height: 30"/>
            </div>
            <@showError "username"/>
        </div>
    <#--password-->
        <div class="control-group">
            <label class="control-label">Password</label>

            <div class="controls">
                <input type="password" class="input-xlarge"
                       value="${user.password}" name="password"
                       placeholder="Password" style="height: 30"/>
            </div>
            <@showError "password"/>
        </div>

        <div class="control-group">
            <label class="control-label">Confirm</label>

            <div class="controls">
                <input type="password" class="input-xlarge"
                       value="${user.conpasswd!""}" name="conpasswd"
                       style="height: 30"/>
            </div>
            <@showError "conpasswd"/>
        </div>
    <#--first name-->
        <div class="control-group">
            <label class="control-label">First name</label>

            <div class="controls">
                <input type="text" class="input-xlarge"
                       value="${user.firstname}" name="firstname"
                       placeholder="First Name" style="height: 30"/>
            </div>
            <@showError "firstname"/>
        </div>
    <#--last name-->
        <div class="control-group">
            <label class="control-label">Last name</label>

            <div class="controls">
                <input type="text" class="input-xlarge"
                       value="${user.lastname}" name="lastname"
                       placeholder="Last name" style="height: 30"/>
            </div>
            <@showError "lastname"/>
        </div>
    <#--Check if user is enabled or disabled in Database. Radiobuttons.-->
        <label class="control-label">Availability</label>

        <div class="controls"
        <div class="col-lg-6">
            <div class="col-lg-6">
                <div>
                    <input type="radio" name="enabled" data-bind="checked: priority"
                           value="${user.enabled?c}"
                    ${user.enabled?string("checked='checked'", "")}
                           style="margin-top: -3px; margin-right: 3px;"/>Enabled
                </div>
                <div>
                    <input type="radio" name="enabled" data-bind="checked: priority"
                           value="${user.enabled?c}"
                    ${user.enabled?string("", "checked='checked' ")}
                           style="margin-top: -3px; margin-right: 3px;"/>Disabled
                </div>
                <br>
            </div>
        </div>
    <#--address-->
        <div class="control-group">
            <label class="control-label">Address</label>

            <div class="controls">
                <input type="text" class="input-xlarge"
                       value="${user.address}" name="address"
                       placeholder="Address" style="height: 30"/>
            </div>
            <@showError "address"/>
        </div>
    <#--e-mail-->
        <div class="control-group">
            <label class="control-label">Email</label>

            <div class="controls">
                <input type="text" class="input-xlarge"
                       value="${user.email}" name="email"
                       placeholder="email" style="height: 30"/>
            </div>
            <@showError "email"/>
        </div>

        <div class="control-group">
            <label class="control-label">Authority</label>

            <div class="controls">
                <@spring.bind path="user.authority.id"/>
                <input type="hidden" value="${spring.status.value}" name="${spring.status.expression}"/>
                <@spring.bind path="user.authority.username"/>
                <input type="hidden" value="${spring.status.value}" name="${spring.status.expression}"/>
                <@spring.bind path="user.authority.authority"/>

                <select name="${spring.status.expression}">
                    <option value="ROLE_ADMIN"
                        <#if spring.status.value = "ROLE_ADMIN"> selected </#if>> ROLE_ADMIN
                    </option>
                    <option value="ROLE_USER"
                        <#if spring.status.value = "ROLE_USER"> selected  </#if>> ROLE_USER
                    </option>
                </select>
            </div>
        </div>

    <#--end of main div-->

    <#--Submit form-->
        <div class="controls-row">
            <label class="control-label"></label>
            <button type="submit" class="btn btn-success" value> Change</button>
            <br> <br>
            <button type="button" class="btn btn" onclick="history.back()" value>Go back</button>
        </div>
    </form>
</div>
</#macro>

<#macro addCategoryForm>
<form action="addCategory" method="post">
    <fieldset>
        <legend>Add category</legend>

        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" name="name"/>
            <@showError "name"/>
        </div>

        <div class="form-group">
            <label for="parentId">Parent category</label>
            <select name="parentId">
                <option value="">None</option>
                <#list categoryListCore as cat>
                    <option value="${cat.id}">${cat.name}</option>
                </#list>
            </select>
        </div>

        <button type="submit" class="btn btn-success">Add category</button>
    </fieldset>
</form>
</#macro>

<#macro categoryList _header>
<#--wyświetlanie listy kategorii-->
<div class="span3">
    <legend class="adminLegend">Category List</legend>
    <div class="well">
        <table class="adminTable table table-hover">
            <tr>${_header}</tr>
            <#list categoryListCore as cat>
                <#if cat.parentCategory??>
                    <#if parentId = cat.parentCategory.id>
                        <tr>
                            <td><a href="categories-${cat.name}-${cat.id}">${cat.name}</a></td>
                            <td><a href="/admin/deleteCategory-${cat.id}" class="btn btn-danger">Delete</a></td>
                        </tr>
                    </#if>
                <#else>
                    <#if parentId = -1>
                        <tr>
                            <td><a href="categories-${cat.name}-${cat.id}">${cat.name}</a></td>
                            <td><a href="/admin/deleteCategory-${cat.id}" class="btn btn-danger">Delete</a></td>
                        </tr>
                    </#if>
                </#if>
            </#list>
        </table>
        <button onclick="history.back()" class="btn btn-info">Back</button>
    </div>
</div>
</#macro>

<#macro orderList>
<legend class="adminLegend">Orders</legend>
<table class="adminTable table table-hover">
    <tr>
        <th>ID</th>
        <th>Date</th>
        <th>Buyer</th>
        <th>Total</th>
        <th>Details</th>
    </tr>
    <#list orderListCore as order>
        <tr>
            <td>${order.id}</td>
            <td>${order.orderDate}</td>
            <td>${order.user.username}</td>
            <td>${order.total}</td>
            <td><a href="/admin/order-${order.id}">
                <button class="btn btn-default">Details</button>
            </a></td>
        </tr>
    </#list>
</table>
</#macro>

<#macro viewOrderDetails>
<legend class="adminLegend">ORDER ID: ${order.id}</legend>
<table class="adminTable table table-hover">

    <tr>
        <th>ID</th>
        <th>Product</th>
        <th>Price per item</th>
        <th>Quantity</th>
    </tr>
    <#list (order.orderItemList) as item>
        <tr>
            <td>${item.id}</td>
            <td>${item.product.name}</td>
            <td>${item.product.price}</td>
            <td>${item.quantity}</td>
            <td></td>
        </tr>
    </#list>
</table>
<div class="controls-row">
    <button type="button" class="btn btn" onclick="history.back()" value> Go back</button>
</div>
</#macro>

<#macro productList>
<fieldset>
    <legend class="adminLegend">Product List</legend>
    <table class="adminTable table table-hover">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
        </tr>

        <tr>
        <#list productListCore as product>
            <tr>
                <td>${product.id}       </td>
                <td>${product.name}     </td>
                <td>${product.price}    </td>
                <td>${product.quantity} </td>
                <td><a href="/admin/deleteProduct-${product.id}">
                    <button class="btn btn-danger">Delete</button>
                </a></td>
            </tr>
        </#list>
        </tr>

    </table>
</fieldset>
</#macro>

<#macro addProductForm>
<form action="addProduct" method="POST">
    <fieldset>
        <legend>Add product</legend>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name">
            <@showError "name"/>
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <input type="text" class="form-control" id="price" name="price">
            <@showError "price"/>
        </div>
        <div class="form-group">
            <label for="quantity">Quantity</label>
            <input type="text" class="form-control" id="quantity" name="quantity">
            <@showError "quantity"/>
        </div>
        <div class="form-group">
            <label for="category">Category</label>
            <select name="categoryId">
                <#list categoryListCore as cat>
                    <option value="${cat.id}">${cat.name}</option>
                </#list>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Add Product</button>
    </fieldset>
</form>
</#macro>

<#--VALIDATION MESSAGES-->

<#macro showErrors>
<div class=text-error>
    <#if errors??>
        <#list errors as error>
        ${error.defaultMessage}<br/>
        </#list>
    </#if>
</div>
</#macro>

<#macro showError paramName>
    <div class=text-error>
        <#if errors??>
            <#list errors as error>
                <#if paramName == error.field>
                    ${error.defaultMessage}<br/>
                </#if>
            </#list>
        </#if>
    </div>
</#macro>

<#--admin panel layout-->
<#macro adminPanelTabs tab>
    <div class="container">
        <div class="tabbable">
            <ul id="adminTabs" class="adminTabs nav nav-tabs">
                <li <#if tab="users">class="active"</#if>><a href="/admin/usersTab">Users</a></li>
                <li <#if tab="categories">class="active"</#if>><a href="/admin/categoriesTab.ftl">Categories</a></li>
                <li <#if tab="products">class="active"</#if>><a href="/admin/productsTab">Products</a></li>
                <li <#if tab="orders">class="active"</#if>><a href="/admin/ordersTab">Orders</a></li>
            </ul>

            <#nested>
        </div>
    </div>
</#macro>
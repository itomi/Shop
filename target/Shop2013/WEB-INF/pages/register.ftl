<#include "macros/main.ftl">
<#include "macros/admin.ftl">

<#assign form=JspTaglibs["http://www.springframework.org/tags/form"] />
<#import "/spring.ftl" as spring />



<@layout _title="Rejestracja" _page="register">
<#--Strona najwazniejsza-->


<#--registered!-->
    <#if error ? has_content>
    <div class="alert-success">
        <h1>Your account have been created succesful.</h1>
    </div>
    </#if>

<#--formularz rejestracyjny-->
<div class="container">
    <div class="well">
        <form id="signup" class="form-horizontal" method="post" action="/check-register">
            <legend>Sign Up</legend>



            <div class="control-group">
                <label class="control-label">Login</label>

                <div class="controls">
                    <div class="input-prepend">
                        <span class="add-on"><i class="icon-user"></i></span>
                        <input type="text" class="input-xlarge" id="username" name="username" placeholder="Login"
                               style="height: 30"
                                <#if user??>
                                   value="${user.username}"
                                </#if>
                                >
                    </div>
                    <@showError "username"/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label">First Name</label>

                <div class="controls">
                    <div class="input-prepend">
                        <span class="add-on"><i class="icon-user"></i></span>
                        <input type="text" class="input-xlarge" id="firstName" name="firstname" placeholder="First Name"
                               style="height: 30"
                            <#if user??>
                               value="${user.firstname}"
                            </#if>
                                >
                    </div>
                    <@showError "firstname"/>
                </div>
            </div>
            <div class="control-group ">
                <label class="control-label">Last Name</label>

                <div class="controls">
                    <div class="input-prepend">
                        <span class="add-on"><i class="icon-user"></i></span>
                        <input type="text" class="input-xlarge" id="lastNAme" name="lastname" placeholder="Last Name"
                               style="height: 30"
                            <#if user??>
                               value="${user.lastname}"
                            </#if>>
                    </div>
                    <@showError "lastname"/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label">Address</label>

                <div class="controls">
                    <div class="input-prepend">
                        <span class="add-on"><i class="icon-user"></i></span>
                        <input type="text" class="input-xlarge" id="address" name="address" placeholder="Address"
                               style="height: 30"
                            <#if user??>
                               value="${user.address}"
                            </#if>>
                    </div>
                    <@showError "address"/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label">Email</label>

                <div class="controls">
                    <div class="input-prepend">
                        <span class="add-on"><i class="icon-envelope"></i></span>
                        <input type="text" class="input-xlarge" id="email" name="email" placeholder="Email"
                               style="height: 30"
                            <#if user??>
                               value="${user.email}"
                            </#if>>
                    </div>
                    <@showError "email"/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">Password</label>

                <div class="controls">
                    <div class="input-prepend">
                        <span class="add-on"><i class="icon-lock"></i></span>
                        <input type="Password" id="password" class="input-large" name="password" placeholder="Password"
                               style="height: 30"
                            <#if user??>
                               value="${user.password}"
                            </#if>>
                    </div>
                    <@showError "password"/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">Confirm Password</label>

                <div class="controls">
                    <div class="input-prepend">
                        <span class="add-on"><i class="icon-lock"></i></span>
                        <input type="Password" id="conpasswd" class="input-large" name="conpasswd"
                               placeholder="Re-enter Password" style="height: 30">
                    </div>
                    <@showError "conpasswd"/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label"></label>

                <div class="controls">
                    <button type="submit" class="btn btn-success">Create Account</button>

                </div>

            </div>

        </form>

    </div>
</div>

</@layout>
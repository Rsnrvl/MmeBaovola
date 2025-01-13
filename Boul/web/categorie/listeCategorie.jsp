<%-- 
    Document   : tableau
    Created on : 26 déc. 2024, 19:28:16
    Author     : aram
--%>

<%@page import="mapping.BddObject"%>
<%@page import="model.*"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
        List<Categorie> categories = BddObject.find(new Categorie(), null); 
%>

<div class="col-lg-12 col-sm-12 col-md-12 col-xl-12 mt-5 mx-auto ml-auto">
    <div class="h-100 bg-light rounded p-4">
        <div class="d-flex flex-row justify-content-between mb-4">    
            <h6 class="mb-0"> Liste des categories des patisseries </h6>
        </div>
       
        <div style="width: 100%">
            <table border="1" class="table table-lg table-bordered">
                <thead>
                    <tr>
                        <th> Id</th>
                        <th> Nom </th>                   
                    </tr>
                </thead>
                <tbody>
                <%
                    for(Categorie cat : categories){ %>
                         <tr>
                             <td><%= cat.getId()%></td>
                        <td><%= cat.getNomCategorie()%></td>
                    </tr>
                    <% }
                %> 
                </tbody>
            </table>
        </div>
    </div>
</div>
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
    List<Facture> factures = BddObject.find(new Facture(), null);
%>

<div class="col-lg-12 col-sm-12 col-md-12 col-xl-12 mt-5 mx-auto ml-auto">
    <div class="h-100 bg-light rounded p-4">
        <div class="d-flex flex-row justify-content-between mb-4">    
            <h6 class="mb-0"> Liste des factures : </h6>
        </div>
       
        <div style="width: 100%">
            <table border="1" class="table table-lg table-bordered">
                <thead>
                    <tr>
                        <th> Date </th>
                        <th> Facture N' </th>
                        <th> Client </th>
                        <th> Status </th>
                        <th>  </th>
                    </tr>
                </thead>
                <tbody>
                   <% for(Facture f : factures){ %>
                        <tr>
                            <td> <%= f.getDateFacture() %> </td>
                            <td> <%= f.getId() %> </td>
                            <td> <%= f.getMyClient().getNomClient() %> </td>
                            <td> <%= f.getEtatString() %> </td>
                            <td class="text-center">
                                <a href="home.jsp?page=facture/detailFacture&&idFacture=<%= f.getId() %>">
                                    <i class="fa fa-eye me-2"> </i>
                                </a>
                            </td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>
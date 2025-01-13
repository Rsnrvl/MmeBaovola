<%-- 
    Document   : formulaire
    Created on : 21 déc. 2024, 18:29:51
    Author     : aram
--%>
<%@page import="mapping.BddObject"%>
<%@page import="model.*"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
        List<Categorie> categories = BddObject.find(new Categorie(), null); 
        List<Parfum> parfums = BddObject.find(new Parfum(), null); 
%>

<div class="col-lg-12 col-sm-12 col-md-12 col-xl-12 mt-5 mb-5" style="margin-left: auto; margin-right: auto">
    <div class="bg-light rounded h-100 p-4">
        <h6 class="mb-4">Inserer Nouvelle Patisserie</h6>
        <form method="POST" action="InsertionPatisserieServlet">
            <div class="form-floating mb-3">
                <input 
                    type="text" 
                    name="nomPatisserie" 
                    class="form-control" 
                    id="floatingInput"
                    placeholder="name@example.com"
                >
                <label for="floatingInput"> Nom  </label>
            </div>
            
            <div class="form-floating mb-3">
                <input 
                    type="number" 
                    name="prixUnitaire" 
                    class="form-control" 
                    id="floatingInput"
                    placeholder="name@example.com"
                >
                <label for="floatingInput"> Prix Unitaire </label>
            </div>
            
             <div class="form-floating mt-3 mb-3">
                <select 
                    class="form-select" 
                    id="floatingSelect" 
                    name="idCategorie"
                    aria-label="Floating label select example"
                >
                    <%
                        for(Categorie categorie : categories){ %>
                            <option value="<%= categorie.getId() %>">
                               <%= categorie.getNomCategorie() %>
                            </option>
                        <% }
                    %>
                </select>
                <label for="floatingSelect"> Categorie</label>
            </div>
                
                
                <div class="form-floating mt-3 mb-3">
                <select 
                    class="form-select" 
                    id="floatingSelect" 
                    name="idParfum"
                    aria-label="Floating label select example"
                >
                    <%
                        for(Parfum parfum : parfums){ %>
                            <option value="<%= parfum.getId() %>">
                               <%= parfum.getNomParfum() %>
                            </option>
                        <% }
                    %>
                </select>
                <label for="floatingSelect"> Parfum</label>
            </div>
            
            <button type="submit" class="btn btn-primary"> Enregistrer </button>
        </form>
    </div>
</div>
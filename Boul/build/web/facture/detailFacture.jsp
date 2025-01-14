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
  String idFacture = (String) request.getParameter("idFacture");
  Facture facture = new Facture();
  facture.setId(idFacture);
  facture = BddObject.findById(facture, null);
  List<FactureFille> ff = facture.getFilles();
  List<Patisserie> patisserie = null;
  // Raha 0 ny etat dia mbola afaka manampy produit
  // fa rehefa enregistrer ilay facture dia tsy afaka 
  // ovaina intsony
  if(facture.getEtat() == 0) 
  {
    patisserie = BddObject.find(new Patisserie(), null);
  }
%>

<div class="col-lg-12 col-sm-12 col-md-12 col-xl-12 mt-5 mx-auto ml-auto">
    <div class="h-100 bg-light rounded p-4">
        <div class="d-flex flex-row justify-content-between mb-4">    
            <h6 class="mb-0"> Detail Facture : <%= idFacture %> </h6>
            <a 
                class="btn btn-success"
                data-bs-toggle="modal" 
                <%-- Mila mitovy @target ilay id any amn modal --%>
                data-bs-target="#detail"
            > 
                Ajouter Produit 
            </a>
            <a 
                class="btn btn-primary"
                href="home.jsp?page=facture/detailFacture&&idFacture=<%= facture.getId() %>"
            > 
                Rafraichir 
            </a>
        </div>
       
        <%-- Detail Facture --%>
        <div 
            style="width: 50%; margin-left: auto;margin-right: auto"
        >
            <table border="1" class="table table-lg table-bordered">
                <thead class="text-center">
                    <tr>
                        <th> Description </th>
                        <th> Valeur </th>  
                    </tr>
                </thead>
                <tbody>
                   
                    <tr>
                        <th> Id </th>
                        <td> <%= facture.getId() %>  </td>
                     
                    </tr>
                    <tr>
                        <th> Date </th>
                        <td> <%= facture.getDateFacture() %> </td>
                    </tr>
                     <tr>
                        <th> Client </th>
                        <td> <%= facture.getMyClient().getNomClient() %></td>
                     </tr>
                </tbody>
            </table>
        </div>
                   
        <div class="d-flex flex-row justify-content-between mb-4 mt-4">    
            <h6 class="mb-0"> Detail de la facture : </h6>
        </div>
        <%-- Liste detail fille --%>
        <div style="width: 100%">
            <table border="1" class="table table-lg table-bordered">
                <thead>
                    <tr>
                        <th> ID Produit </th>
                        <th> Nom </th>
                        <th> P.U </th>
                        <th> QTY </th>
                        <th> Montant </th>
                    </tr>
                </thead>
                <tbody>
                    
                        <% for(FactureFille f : ff){ %>
                            <tr>
                                <td><%= f.getMyPatisserie().getId() %></td>
                                <td><%= f.getMyPatisserie().getNomPatisserie() %></td>
                                <td>Ar <%= f.getPuPatisserie() %></td>
                                <td><%= f.getQuantite() %></td>
                                <td>Ar <%= f.getMontantTotal() %></td>
                            </tr>
                        <% } %>

                </tbody>
            </table>
        </div>
    </div>
</div>
                     
   <!-- MODAL AJOUT PRODUIT -->
    <div class="modal fade" id="detail" tabindex="-1" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content" >
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalCenterTitle"> Choisir parmi les patisseries : <b> </b>  </h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="btn-close"></button>
            </div>
              
            <form action="InsertionFactureFille" method="POST">
                <input 
                    type="hidden" 
                    name="idFacture" 
                    value="<%= facture.getId() %>"
                >
                <div class="modal-body">
                    <div class="form-floating mb-3">
                        <select 
                            class="form-select" 
                            id="floatingSelect" 
                          <form action="InsertionFactureFille" method="POST">
                <input 
                    type="hidden" 
                    name="idFacture" 
                    value="<%= facture.getId() %>"
                >
                <div class="modal-body">
                    <div class="form-floating mb-3">
                        <select 
                              name="idPatisserie"
                            aria-label="Floating label select example"
                        >
                            <%
                                for(Patisserie p : patisserie){ %>
                                    <option value="<%= p.getId() %>">
                                       <%= p.getNomPatisserie() %> 
                                    </option>
                                <% }
                            %>
                        </select>
                        <label for="floatingSelect"> Choisir ici ... </label>
                    </div>
                        
                    <div class="form-floating mb-3">
                       <input type="text" name="qty" class="form-control" id="floatingInput"
                           placeholder="name@example.com">
                       <label for="floatingInput"> Quantity </label>
                   </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary"> Enregistrer </button>
                </div>
            </form>
        </div>
      </div>
    </div>
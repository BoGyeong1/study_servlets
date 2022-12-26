<%@ page import="java.util.HashMap, java.util.ArrayList" %>

  <% 
    HashMap<String, String> searchForm = (HashMap<String, String>)request.getAttribute("searchForm");
    ArrayList<String> tablesListWithString =(ArrayList<String>)request.getAttribute("tablesListWithString");
   %>
    <div class="fs-3">Navigation bars basic</div>
    <nav class="navbar navbar-expand bg-light">
      <div class="navbar-nav">
        <a href="" class="nav-item nav-link">Home</a>
        <a href="" class="nav-item nav-link">Feature</a>
        <a href="" class="nav-item nav-link">Pricing</a>
      </div>
    </nav>

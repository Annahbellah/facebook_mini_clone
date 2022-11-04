<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 04/11/2022
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import="dev.decagon.facebookcloneapp.model.User"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Facebook Clone</title>
  <link rel="stylesheet" href="style.css" />
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<!-- header starts -->
<div class="header">
  <div class="header__left">
    <img
            src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Facebook_f_logo_%282019%29.svg/1200px-Facebook_f_logo_%282019%29.svg.png"
            alt=""
    />
    <div class="header__input">
      <span class="material-icons"> search </span>
      <input type="text" placeholder="Search Facebook" />
    </div>
  </div>

  <div class="header__middle">
    <div class="header__option active">
      <span class="material-icons"> home </span>
    </div>
    <div class="header__option">
      <span class="material-icons"> flag </span>
    </div>
    <div class="header__option">
      <span class="material-icons"> subscriptions </span>
    </div>
    <div class="header__option">
      <span class="material-icons"> storefront </span>
    </div>
    <div class="header__option">
      <span class="material-icons"> supervised_user_circle </span>
    </div>
  </div>

  <div class="header__right">
    <div class="header__info">

      <h4><c:out value="${sessionScope.username }"/></h4>

    </div>
    <span class="material-icons"> logout </span>
  </div>
</div>
<!-- header ends -->



<!-- main body starts -->
<div class="main__body">
  <!-- sidebar starts -->
  <div class="sidebar">
    <div class="sidebarRow">

      <h4><c:out value="${sessionScope.username }"/></h4>
    </div>

    <div class="sidebarRow">
      <span class="material-icons"> local_hospital </span>
      <h4>Medics</h4>
    </div>

    <div class="sidebarRow">
      <span class="material-icons"> emoji_flags </span>
      <h4>Pages</h4>
    </div>

    <div class="sidebarRow">
      <span class="material-icons"> people </span>
      <h4>People</h4>
    </div>

    <div class="sidebarRow">
      <span class="material-icons"> chat </span>
      <h4>Messenger</h4>
    </div>

    <div class="sidebarRow">
      <span class="material-icons"> storefront </span>
      <h4>Marketplace</h4>
    </div>

    <div class="sidebarRow">
      <span class="material-icons"> video_library </span>
      <h4>Videos</h4>
    </div>

    <div class="sidebarRow">
      <span class="material-icons"> expand_more </span>
      <h4>More</h4>
    </div>
  </div>
  <!-- sidebar ends -->

  <!-- feed starts -->
  <div class="feed">
    <div class="storyReel">
      <!-- story starts -->
      <div
              style="
              background-image: url('https://images.unsplash.com/photo-1527082395-e939b847da0d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80');
            "
              class="story"
      >

      </div>
      <!-- story ends -->

      <!-- story starts -->
      <div
              style="
              background-image: url('https://cellularnews.com/wp-content/uploads/2020/04/Delete-photo-337x600.jpg');
            "
              class="story"
      >

      </div>
      <!-- story ends -->

      <!-- story starts -->
      <div
              style="
              background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTBHC2s4NFdzXEsVzvBPGjkrSePQa-8XFuNtQ&usqp=CAU');
            "
              class="story"
      >

      </div>
      <!-- story ends -->

      <!-- story starts -->
      <div
              style="
              background-image: url('https://images.unsplash.com/photo-1527082395-e939b847da0d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80');
            "
              class="story"
      >

      </div>
      <!-- story ends -->

      <!-- story starts -->
      <div
              style="
              background-image: url('https://cellularnews.com/wp-content/uploads/2020/04/Delete-photo-337x600.jpg');
            "
              class="story"
      >


      </div>
      <!-- story ends -->

      <!-- story starts -->
      <div
              style="
              background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTBHC2s4NFdzXEsVzvBPGjkrSePQa-8XFuNtQ&usqp=CAU');
            "
              class="story"
      >

      </div>
      <!-- story ends -->
    </div>

    <!-- message sender starts -->
    <div class="messageSender">
      <div class="messageSender__top row">
        <form action="newpost" method="post" >
          <input name="textbody" type="text" class="messageSender__input col-8" placeholder="What's on your mind?"  />
          <input type="submit" value="Post" class="btn btn-primary btn-small">
        </form>

      </div>


    </div>
    <!-- message sender ends -->

    <!-- post starts -->

<c:forEach var="tempPost" items="${posts}">  <!-- LIST OF POSTS -->

    <br><br>
    <div class="container posts">
      <div class="card">
        <div class="card-header post__top">
          <div class="row ost__topInfo">
            <h3 class="card-title poster">${tempPost.getUserName()}</h3>
          </div>
        </div>
        <div class="card-body">
          <div class="post__bottom">
            <p>${tempPost.getTextBody()}</p>
          </div>
          <div class="post__options">
            <div class="post__option">
              <span class="material-icons"> thumb_up </span>
              <p>${tempPost.getLikes()}</p>
            </div>

            <div class="post__option">
              <span class="material-icons"> chat_bubble_outline </span>
              <p>Comment</p>
            </div>

            <div class="post__option">
              <span class="material-icons"> edit </span>
              <p>Edit</p>
            </div>

            <div class="post__option">
              <span class="material-icons"> delete </span>
              <p>Delete</p>
            </div>
          </div>
        </div>

      </div>



      <!-- post ends -->
    </div>
</c:forEach>
    <!-- feed ends -->

    <div style="flex: 0.33" class="widgets">
      <div
              class="fb-page"
              data-href="https://www.facebook.com/facebook"
              data-tabs="timeline"
              data-width="500"
              data-height="1000"
              data-small-header="false"
              data-adapt-container-width="true"
              data-hide-cover="false"
              data-show-facepile="true"
      >

        </blockquote>
      </div>
    </div>
  </div>
  <!-- main body ends -->

  <div id="fb-root"></div>
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
          integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
          crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
          integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
          crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
          integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
          crossorigin="anonymous"></script>
  <%--<!-- <script--%>
</html>





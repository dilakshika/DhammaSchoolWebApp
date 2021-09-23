<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.itpm.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">


<!-- Mirrored from wrappixel.com/demos/admin-templates/xtreme-admin/html/dark/timeline-horizontal.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 06 Feb 2019 04:30:10 GMT -->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="assets/images/favicon.png">
    <title>Dhamma School -Student Management System</title>
    <!-- Custom CSS -->
    <link href="assets/extra-libs/horizontal-timeline/horizontal-timeline.css" rel="stylesheet">
    <link href="dist/css/style.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="assets/libs/pickadate/lib/themes/default.css">
    <link rel="stylesheet" type="text/css" href="assets/libs/pickadate/lib/themes/default.date.css">
    <link rel="stylesheet" type="text/css" href="assets/libs/pickadate/lib/themes/default.time.css">
    <link rel="stylesheet" type="text/css" href="assets/libs/bootstrap-switch/dist/css/bootstrap3/bootstrap-switch.min.css">
    <link rel="stylesheet" type="text/css" href="assets/libs/dropzone/dist/min/dropzone.min.css">
    
    <link rel="stylesheet" type="text/css" href="assets/libs/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">



    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<style type="text/css">
input[type="text"]
{
    font-size:12px;
}

</style>

</head>

<body>
    <!-- ============================================================== -->
    <!-- Preloader - style you can find in spinners.css -->
    <!-- ============================================================== -->
    <div class="preloader">
        <div class="lds-ripple">
            <div class="lds-pos"></div>
            <div class="lds-pos"></div>
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- Main wrapper - style you can find in pages.scss -->
    <!-- ============================================================== -->
    <div id="main-wrapper">
        <!-- ============================================================== -->
        <!-- Topbar header - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <header class="topbar">
            <nav class="navbar top-navbar navbar-expand-md navbar-dark">
                <div class="navbar-header">
                    <!-- This is for the sidebar toggle which is visible on mobile only -->
                    <a class="nav-toggler waves-effect waves-light d-block d-md-none" href="javascript:void(0)"><i class="ti-menu ti-close"></i></a>
                    <!-- ============================================================== -->
                    <!-- Logo -->
                    <!-- ============================================================== -->
                    <a class="navbar-brand" href="index-2.html">
                        <!-- Logo icon -->
                        <b class="logo-icon">
                            <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
                            <!-- Dark Logo icon -->
                            <img src="assets/images/logo-icon.png" alt="homepage" class="dark-logo" />
                            <!-- Light Logo icon -->
                            <img src="assets/images/logo-light-icon.png" alt="homepage" class="light-logo" />
                        </b>
                        <!--End Logo icon -->
                        <!-- Logo text -->
                        <span class="logo-text">
                             <!-- dark Logo text -->
                             <img src="assets/images/logo-text.png" alt="homepage" class="dark-logo" />
                             <!-- Light Logo text -->    
                             <img src="assets/images/logo-light-text.png" class="light-logo" alt="homepage" />
                        </span>
                    </a>
                    <!-- ============================================================== -->
                    <!-- End Logo -->
                    <!-- ============================================================== -->
                    <!-- ============================================================== -->
                    <!-- Toggle which is visible on mobile only -->
                    <!-- ============================================================== -->
                    <a class="topbartoggler d-block d-md-none waves-effect waves-light" href="javascript:void(0)" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><i class="ti-more"></i></a>
                </div>
                <!-- ============================================================== -->
                <!-- End Logo -->
                <!-- ============================================================== -->
                <div class="navbar-collapse collapse" id="navbarSupportedContent">
                    <!-- ============================================================== -->
                    <!-- toggle and nav items -->
                    <!-- ============================================================== -->
                    <ul class="navbar-nav float-left mr-auto">
                        <li class="nav-item d-none d-md-block"><a class="nav-link sidebartoggler waves-effect waves-light" href="javascript:void(0)" data-sidebartype="mini-sidebar"><i class="mdi mdi-menu font-24"></i></a></li>
                        <!-- ============================================================== -->
                        <!-- mega menu -->
                        <!-- ============================================================== -->
                        <!-- ============================================================== -->
                        <!-- End mega menu -->
                        <!-- ============================================================== -->
                        <!-- ============================================================== -->
                        <!-- create new -->
                        <!-- ============================================================== -->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                             <span class="d-none d-md-block">Create New <i class="fa fa-angle-down"></i></span>
                             <span class="d-block d-md-none"><i class="fa fa-plus"></i></span>   
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Action</a>
                                <a class="dropdown-item" href="#">Another action</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Something else here</a>
                            </div>
                        </li>
                        <!-- ============================================================== -->
                        <!-- Search -->
                        <!-- ============================================================== -->
                        <li class="nav-item search-box"> <a class="nav-link waves-effect waves-dark" href="javascript:void(0)"><i class="ti-search"></i></a>
                            <form class="app-search position-absolute">
                                <input type="text" class="form-control" placeholder="Search &amp; enter"> <a class="srh-btn"><i class="ti-close"></i></a>
                            </form>
                        </li>
                    </ul>
                    <!-- ============================================================== -->
                    <!-- Right side toggle and nav items -->
                    <!-- ============================================================== -->
                    <ul class="navbar-nav float-right">
                        <!-- ============================================================== -->
                        <!-- create new -->
                        <!-- ============================================================== -->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              <i class="flag-icon flag-icon-us"></i>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right  animated bounceInDown" aria-labelledby="navbarDropdown2">
                                <a class="dropdown-item" href="#"><i class="flag-icon flag-icon-us"></i> English</a>
                                <a class="dropdown-item" href="#"><i class="flag-icon flag-icon-fr"></i> French</a>
                                <a class="dropdown-item" href="#"><i class="flag-icon flag-icon-es"></i> Spanish</a>
                                <a class="dropdown-item" href="#"><i class="flag-icon flag-icon-de"></i> German</a>
                            </div>
                        </li>
                        <!-- ============================================================== -->
                        <!-- Comment -->
                        <!-- ============================================================== -->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle waves-effect waves-dark" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="mdi mdi-bell font-24"></i>
                                
                            </a>
                            <div class="dropdown-menu dropdown-menu-right mailbox animated bounceInDown">
                                <span class="with-arrow"><span class="bg-primary"></span></span>
                                <ul class="list-style-none">
                                    <li>
                                        <div class="drop-title bg-primary text-white">
                                            <h4 class="m-b-0 m-t-5">4 New</h4>
                                            <span class="font-light">Notifications</span>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="message-center notifications">
                                            <!-- Message -->
                                            <a href="javascript:void(0)" class="message-item">
                                                <span class="btn btn-danger btn-circle"><i class="fa fa-link"></i></span>
                                                <div class="mail-contnet">
                                                    <h5 class="message-title">Luanch Admin</h5> <span class="mail-desc">Just see the my new admin!</span> <span class="time">9:30 AM</span> </div>
                                            </a>
                                            <!-- Message -->
                                            <a href="javascript:void(0)" class="message-item">
                                                <span class="btn btn-success btn-circle"><i class="ti-calendar"></i></span>
                                                <div class="mail-contnet">
                                                    <h5 class="message-title">Event today</h5> <span class="mail-desc">Just a reminder that you have event</span> <span class="time">9:10 AM</span> </div>
                                            </a>
                                            <!-- Message -->
                                            <a href="javascript:void(0)" class="message-item">
                                                <span class="btn btn-info btn-circle"><i class="ti-settings"></i></span>
                                                <div class="mail-contnet">
                                                    <h5 class="message-title">Settings</h5> <span class="mail-desc">You can customize this template as you want</span> <span class="time">9:08 AM</span> </div>
                                            </a>
                                            <!-- Message -->
                                            <a href="javascript:void(0)" class="message-item">
                                                <span class="btn btn-primary btn-circle"><i class="ti-user"></i></span>
                                                <div class="mail-contnet">
                                                    <h5 class="message-title">Pavan kumar</h5> <span class="mail-desc">Just see the my admin!</span> <span class="time">9:02 AM</span> </div>
                                            </a>
                                        </div>
                                    </li>
                                    <li>
                                        <a class="nav-link text-center m-b-5 text-dark" href="javascript:void(0);"> <strong>Check all notifications</strong> <i class="fa fa-angle-right"></i> </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <!-- ============================================================== -->
                        <!-- End Comment -->
                        <!-- ============================================================== -->
                        <!-- ============================================================== -->
                        <!-- Messages -->
                        <!-- ============================================================== -->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle waves-effect waves-dark" href="#" id="2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="font-24 mdi mdi-comment-processing"></i>
                                
                            </a>
                            <div class="dropdown-menu dropdown-menu-right mailbox animated bounceInDown" aria-labelledby="2">
                                <span class="with-arrow"><span class="bg-danger"></span></span>
                                <ul class="list-style-none">
                                    <li>
                                        <div class="drop-title text-white bg-danger">
                                            <h4 class="m-b-0 m-t-5">5 New</h4>
                                            <span class="font-light">Messages</span>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="message-center message-body">
                                            <!-- Message -->
                                            <a href="javascript:void(0)" class="message-item">
                                                <span class="user-img"> <img src="assets/images/users/1.jpg" alt="user" class="rounded-circle"> <span class="profile-status online pull-right"></span> </span>
                                                <div class="mail-contnet">
                                                    <h5 class="message-title">Pavan kumar</h5> <span class="mail-desc">Just see the my admin!</span> <span class="time">9:30 AM</span> </div>
                                            </a>
                                            <!-- Message -->
                                            <a href="javascript:void(0)" class="message-item">
                                                <span class="user-img"> <img src="assets/images/users/2.jpg" alt="user" class="rounded-circle"> <span class="profile-status busy pull-right"></span> </span>
                                                <div class="mail-contnet">
                                                    <h5 class="message-title">Sonu Nigam</h5> <span class="mail-desc">I've sung a song! See you at</span> <span class="time">9:10 AM</span> </div>
                                            </a>
                                            <!-- Message -->
                                            <a href="javascript:void(0)" class="message-item">
                                                <span class="user-img"> <img src="assets/images/users/3.jpg" alt="user" class="rounded-circle"> <span class="profile-status away pull-right"></span> </span>
                                                <div class="mail-contnet">
                                                    <h5 class="message-title">Arijit Sinh</h5> <span class="mail-desc">I am a singer!</span> <span class="time">9:08 AM</span> </div>
                                            </a>
                                            <!-- Message -->
                                            <a href="javascript:void(0)" class="message-item">
                                                <span class="user-img"> <img src="assets/images/users/4.jpg" alt="user" class="rounded-circle"> <span class="profile-status offline pull-right"></span> </span>
                                                <div class="mail-contnet">
                                                    <h5 class="message-title">Pavan kumar</h5> <span class="mail-desc">Just see the my admin!</span> <span class="time">9:02 AM</span> </div>
                                            </a>
                                        </div>
                                    </li>
                                    <li>
                                        <a class="nav-link text-center link text-dark" href="javascript:void(0);"> <b>See all e-Mails</b> <i class="fa fa-angle-right"></i> </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <!-- ============================================================== -->
                        <!-- End Messages -->
                        <!-- ============================================================== -->
                        <!-- ============================================================== -->
                        <!-- User profile and search -->
                        <!-- ============================================================== -->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark pro-pic" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="assets/images/users/1.jpg" alt="user" class="rounded-circle" width="31"></a>
                            <div class="dropdown-menu dropdown-menu-right user-dd animated flipInY">
                                <span class="with-arrow"><span class="bg-primary"></span></span>
                                <div class="d-flex no-block align-items-center p-15 bg-primary text-white m-b-10">
                                    <div class=""><img src="assets/images/users/1.jpg" alt="user" class="img-circle" width="60"></div>
                                    <div class="m-l-10">
                                        <h4 class="m-b-0">Steave Jobs</h4>
                                        <p class=" m-b-0">varun@gmail.com</p>
                                    </div>
                                </div>
                                <a class="dropdown-item" href="javascript:void(0)"><i class="ti-user m-r-5 m-l-5"></i> My Profile</a>
                                <a class="dropdown-item" href="javascript:void(0)"><i class="ti-wallet m-r-5 m-l-5"></i> My Balance</a>
                                <a class="dropdown-item" href="javascript:void(0)"><i class="ti-email m-r-5 m-l-5"></i> Inbox</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="javascript:void(0)"><i class="ti-settings m-r-5 m-l-5"></i> Account Setting</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="javascript:void(0)"><i class="fa fa-power-off m-r-5 m-l-5"></i> Logout</a>
                                <div class="dropdown-divider"></div>
                                <div class="p-l-30 p-10"><a href="javascript:void(0)" class="btn btn-sm btn-success btn-rounded">View Profile</a></div>
                            </div>
                        </li>
                        <!-- ============================================================== -->
                        <!-- User profile and search -->
                        <!-- ============================================================== -->
                    </ul>
                </div>
            </nav>
        </header>
        <!-- ============================================================== -->
        <!-- End Topbar header -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <aside class="left-sidebar">
            <!-- Sidebar scroll-->
            <div class="scroll-sidebar">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                    <ul id="sidebarnav">
                        <!-- User Profile-->
                        <li>
                            <!-- User Profile-->
                            <div class="user-profile d-flex no-block dropdown mt-3">
                                <div class="user-pic"><img src="assets/images/users/1.jpg" alt="users" class="rounded-circle" width="40" /></div>
                                <div class="user-content hide-menu ml-2">
                                    <a href="javascript:void(0)" class="" id="Userdd" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <h5 class="mb-0 user-name font-medium">Steave Jobs <i class="fa fa-angle-down"></i></h5>
                                        <span class="op-5 user-email">varun@gmail.com</span>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="Userdd">
                                        <a class="dropdown-item" href="javascript:void(0)"><i class="ti-user mr-1 ml-1"></i> My Profile</a>
                                        <a class="dropdown-item" href="javascript:void(0)"><i class="ti-wallet mr-1 ml-1"></i> My Balance</a>
                                        <a class="dropdown-item" href="javascript:void(0)"><i class="ti-email mr-1 ml-1"></i> Inbox</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="javascript:void(0)"><i class="ti-settings mr-1 ml-1"></i> Account Setting</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="javascript:void(0)"><i class="fa fa-power-off mr-1 ml-1"></i> Logout</a>
                                    </div>
                                </div>
                            </div>
                            <!-- End User Profile-->
                        </li>
                        <!-- User Profile-->
                        <li class="nav-small-cap"><i class="mdi mdi-dots-horizontal"></i> <span class="hide-menu text-success">Components</span></li>
                      
                                    <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link" href="dashboard.html" aria-expanded="false"><i class="mdi mdi-view-dashboard"></i><span class="hide-menu">Dashboard</span></a></li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link" href="homeView.jsp" aria-expanded="false"><i class="mdi mdi-account-card-details"></i><span class="hide-menu">Student Master</span></a></li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link" href="userView.jsp" aria-expanded="false"><i class=" fas fa-address-book"></i><span class="hide-menu">Staff Master</span></a></li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link" href="resultView.jsp" aria-expanded="false"><i class="ti-agenda"></i><span class="hide-menu">Exam Master</span></a></li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link" href="eventView.jsp" aria-expanded="false"><i class="mdi mdi-account-convert"></i><span class="hide-menu">Event Master</span></a></li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link" href="timetableView.jsp" aria-expanded="false"><i class="ti-agenda"></i><span class="hide-menu">Academic Master</span></a></li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link" href="attendanceView.jsp" aria-expanded="false"><i class="mdi mdi-account-star"></i><span class="hide-menu">Attendance Master</span></a></li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link" href="noticeView.jsp" aria-expanded="false"><i class="mdi mdi-file-multiple"></i><span class="hide-menu">Notice Master</span></a></li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link" href="userMaster.html" aria-expanded="false"><i class="mdi mdi-account-key"></i><span class="hide-menu">User Master</span></a></li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link" href="login.html" aria-expanded="false"><i class="mdi mdi-power"></i><span class="hide-menu">Logout</span></a></li> </ul>
              </ul>
                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
        </aside>
        <!-- ============================================================== -->
        <!-- End Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper">
            <!-- ============================================================== -->
            <!-- Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->

            <!-- ============================================================== -->
            <!-- End Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <div class="container-fluid">
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                               <div class="row m-0 p-0">
                            <div class="col-md-6  h-100 w-100">
                                <h3 class="card-title" style="font-family: Arial, Helvetica, sans-serif;">View Student</h3>
                             </div>  
                             <div class="col-md-6  h-100 w-100"> 
				<form method="POST" action="ListStudentServlet">
			<input type="image" src="assets/images/CRUD/view_all.png" style="float: right;width:35px; height:35px" data-toggle="tooltip" data-placement="bottom" title="VIEW ALL RESULTS" alt="Submit">
	</form>
	</div>
	</div>
                                <h6 class="card-subtitle"></h6>
                               <div class="table-responsive">
                                <%
                                	Student student = (Student) request.getAttribute("student");
                                %>
<form autocomplete="off" method="POST" action="GetStudentServlet" style="font-family: Arial, Helvetica, sans-serif; color: gray; ">
	 <div class="row m-0 p-0">
	  <div class="col-md-6  h-100 w-100">
        <br />
        <label class="lablFont">Student ID </label>
        <br />
        <input id="InNo" name="InNo" disabled="disabled" type="text" class="form-control" style="color:#F8F8FF; text-transform:uppercase;" value="<%=student.getInNo()%>" >
      </div>
      </div>
       <div class="row m-0 p-0">
                    <div class="col-md-6  h-100 w-100">
                        <br />
                        <label class="lablFont">First Name </label>
                        <br />
                        <input id="Fname" name="Fname" disabled="disabled" type="text" class="form-control" style="color:#F8F8FF; text-transform:uppercase;" value="<%=student.getFname()%>" >
                    </div>
                    <div class="col-md-6  h-100 w-100">
                        <br />
                        <label class="lablFont">Last Name </label>
                        <br />
                            <input id="IName" name="IName" disabled="disabled" type="text" class="form-control" style="color:#F8F8FF; text-transform:uppercase;" value="<%=student.getIName()%>" >
                    </div>
				</div>
           <div class="row m-2 p-0"></div>
				<div class="row m-0 p-0">
                    <div class="col-md-12  h-100 w-100">
                        <label class="lablFont">Address </label>
                        <br />
                        <input id="Address" name="Address" disabled="disabled" type="text" class="form-control" style="height: 60px; color:#F8F8FF; text-transform:uppercase;" value="<%=student.getAddress()%>" >
                    </div>
                </div>
                <div class="row m-0 p-0">
                    <div class="col-md-6  h-100 w-100">
                        <br />
                        <label class="lablFont">Birthday </label>
                        <br />
                        <input id="Birthday" name="Birthday" disabled="disabled" type="text" class="form-control" style="color:#F8F8FF; text-transform:uppercase;" value="<%=student.getBirthday()%>" >
                    </div>
                    <div class="col-md-6  h-100 w-100">
                        <br />
                        <label class="lablFont">Gender </label>
                        <br />
                            <input id="Gender" name="Gender" disabled="disabled" type="text" class="form-control" style="color:#F8F8FF; text-transform:uppercase;" value="<%=student.getGender()%>" >
                    </div>
				</div>
				
                <div class="row m-2 p-0"></div>
                
                <div class="row m-0 p-0">
                    <div class="col-md-6  h-100 w-100">
                        <br />
                        <label class="lablFont">Guardian </label>
                        <br />
                            <input id="Guardian" name="Guardian" disabled="disabled" type="text" class="form-control" style="color:#F8F8FF; text-transform:uppercase;" value="<%=student.getGuardian()%>" >
                    </div>
                    <div class="col-md-6  h-100 w-100">
                        <br />
                        <label class="lablFont">Mobile </label>
                        <br />
                            <input id="Mobile" name="Mobile" disabled="disabled" type="text" class="form-control" style="color:#F8F8FF; text-transform:uppercase;" value="<%=student.getMobile()%>" >
                    </div>
				</div>
				<div class="row m-2 p-0"></div>
                
                <div class="row m-0 p-0">
                    <div class="col-md-6  h-100 w-100">
                        <br />
                        <label class="lablFont">ADate </label>
                        <br />
                            <input id="ADate" name="ADate" disabled="disabled" type="text" class="form-control" style="color:#F8F8FF; text-transform:uppercase;" value="<%=student.getADate()%>" >
                    </div>
                    <div class="col-md-6  h-100 w-100">
                        <br />
                        <label class="lablFont">position </label>
                        <br />
                            <input id="position" name="position" disabled="disabled" type="text" class="form-control" style="color:#F8F8FF; text-transform:uppercase;" value="<%=student.getPosition()%>" >
                     </div>
				</div>
                
               
                <div class="row m-1 p-0">
                </div>
                <div class="row m-0 p-0">
                    <div class="col-md-12  h-100 w-100">
                        <label class="lablFont">Comment </label>
                        <br />
                     <input id="Comment" name="Comment" disabled="disabled" type="text" class="form-control" style="height: 100px;color:#F8F8FF; text-transform:uppercase;" value="<%=student.getComment()%>" >
                    </div>
                </div>         
		
	</form>
	
		
	<br>
	<button type="button" class="btn btn-danger" id="demo">PDF</button>

<script>
document.getElementById("demo").addEventListener("click", myFunction);

function myFunction() {
  var sTable = document.getElementById('demo').innerHTML;

        var style = "<style>";
      
       
  
      
        style = style + "h2 {color: white; text-align: center;background-color: #2e4ead;padding: 8px 20px;margin: 8px 0;}";
        style = style + "table {width: 80%;font: 20px Calibri;}";
        style = style + "table, th, td  {  border: 1px solid #ddd; background-color: #f2f2f2;  border-collapse: collapse; ";
        style = style + "padding: 15px;text-align: center;}";
        style = style + "</style>";

        // CREATE A WINDOW OBJECT.
        var win = window.open('', '', 'height=700,width=700');

        
      	<% DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
       	String date = df.format(dateobj);
        %>
        win.document.write('<center><h2>Dhamma School - Student</h2></center>');
        win.document.write('<br>');
        win.document.write('<h3>Student ID: <%=student.getInNo()%></h3>');
        win.document.write('<h3>Student Name: <%=student.getFname() + student.getIName() %></h3>');
        win.document.write('<h3>  Date: <%= date %> </h3>'); 
     
  
       
        
           

        win.document.write(style);          // ADD STYLE INSIDE THE HEAD TAG.
        
        win.document.write('<center><body>');
        win.document.write('<table><tr><th>Name</th><th>Gender</th><th>Address</th><th>Guardian</th><th>Mobile</th><th>Comment</th></tr>'); 
        win.document.write('<tr><td><%=student.getFname() + student.getIName() %></td><td><%=student.getGender()%></td><td><%=student.getAddress()%></td><td><%=student.getGuardian()%></td><td><%=student.getMobile()%></td><td><%=student.getComment()%></td></tr>'); 
        
        win.document.write('<br>');
        win.document.write('<hr>');
        win.document.write('</center>');
        win.document.write('<br>');
   
     
           win.document.write('<br>');
        
        win.document.write('</body></center></html>');

        win.document.close(); 	// CLOSE THE CURRENT WINDOW.

        win.print();    // PRINT THE CONTENTS.
}
</script>
                            </div>
                            </div>
                        </div>

                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- End PAge Content -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Right sidebar -->
                <!-- ============================================================== -->
                <!-- .right-sidebar -->
                <!-- ============================================================== -->
                <!-- End Right sidebar -->
                <!-- ============================================================== -->
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- footer -->
            <!-- ============================================================== -->
            <footer class="footer text-center">
       All Rights Reserved by Xtreme admin. Designed and Developed by <a href="https://wrappixel.com/">WrapPixel</a>.
</footer>
            <!-- ============================================================== -->
            <!-- End footer -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- End Page wrapper  -->
        <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- End Wrapper -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- customizer Panel -->
    <!-- ============================================================== -->
    <aside class="customizer">
        <a href="javascript:void(0)" class="service-panel-toggle"><i class="fa fa-spin fa-cog"></i></a>
        <div class="customizer-body">
            <ul class="nav customizer-tab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab" aria-controls="pills-home" aria-selected="true"><i class="mdi mdi-wrench font-20"></i></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#chat" role="tab" aria-controls="chat" aria-selected="false"><i class="mdi mdi-message-reply font-20"></i></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#pills-contact" role="tab" aria-controls="pills-contact" aria-selected="false"><i class="mdi mdi-star-circle font-20"></i></a>
                </li>
            </ul>
            <div class="tab-content" id="pills-tabContent">
                <!-- Tab 1 -->
                <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
                    <div class="p-15 border-bottom">
                        <!-- Sidebar -->
                        <h5 class="font-medium m-b-10 m-t-10">Layout Settings</h5>
                        <div class="custom-control custom-checkbox m-t-10">
                            <input type="checkbox" class="custom-control-input" name="theme-view" id="theme-view">
                            <label class="custom-control-label" for="theme-view">Dark Theme</label>
                        </div>
                        <div class="custom-control custom-checkbox m-t-10">
                            <input type="checkbox" class="custom-control-input sidebartoggler" name="collapssidebar" id="collapssidebar">
                            <label class="custom-control-label" for="collapssidebar">Collapse Sidebar</label>
                        </div>
                        <div class="custom-control custom-checkbox m-t-10">
                            <input type="checkbox" class="custom-control-input" name="sidebar-position" id="sidebar-position">
                            <label class="custom-control-label" for="sidebar-position">Fixed Sidebar</label>
                        </div>
                        <div class="custom-control custom-checkbox m-t-10">
                            <input type="checkbox" class="custom-control-input" name="header-position" id="header-position">
                            <label class="custom-control-label" for="header-position">Fixed Header</label>
                        </div>
                        <div class="custom-control custom-checkbox m-t-10">
                            <input type="checkbox" class="custom-control-input" name="boxed-layout" id="boxed-layout">
                            <label class="custom-control-label" for="boxed-layout">Boxed Layout</label>
                        </div>
                    </div>
                    <div class="p-15 border-bottom">
                        <!-- Logo BG -->
                        <h5 class="font-medium m-b-10 m-t-10">Logo Backgrounds</h5>
                        <ul class="theme-color">
                            <li class="theme-item"><a href="javascript:void(0)" class="theme-link" data-logobg="skin1"></a></li>
                            <li class="theme-item"><a href="javascript:void(0)" class="theme-link" data-logobg="skin2"></a></li>
                            <li class="theme-item"><a href="javascript:void(0)" class="theme-link" data-logobg="skin3"></a></li>
                            <li class="theme-item"><a href="javascript:void(0)" class="theme-link" data-logobg="skin4"></a></li>
                            <li class="theme-item"><a href="javascript:void(0)" class="theme-link" data-logobg="skin5"></a></li>
                            <li class="theme-item"><a href="javascript:void(0)" class="theme-link" data-logobg="skin6"></a></li>
                        </ul>
                        <!-- Logo BG -->
                    </div>
                    <div class="p-15 border-bottom">
                        <!-- Navbar BG -->
                        <h5 class="font-medium m-b-10 m-t-10">Navbar Backgrounds</h5>
                        <ul class="theme-color">
                            <li class="theme-item"><a href="javascript:void(0)" class="theme-link" data-navbarbg="skin1"></a></li>
                            <li class="theme-item"><a href="javascript:void(0)" class="theme-link" data-navbarbg="skin2"></a></li>
                            <li class="theme-item"><a href="javascript:void(0)" class="theme-link" data-navbarbg="skin3"></a></li>
                            <li class="theme-item"><a href="javascript:void(0)" class="theme-link" data-navbarbg="skin4"></a></li>
                            <li class="theme-item"><a href="javascript:void(0)" class="theme-link" data-navbarbg="skin5"></a></li>
                            <li class="theme-item"><a href="javascript:void(0)" class="theme-link" data-navbarbg="skin6"></a></li>
                        </ul>
                        <!-- Navbar BG -->
                    </div>
                    <div class="p-15 border-bottom">
                        <!-- Logo BG -->
                        <h5 class="font-medium m-b-10 m-t-10">Sidebar Backgrounds</h5>
                        <ul class="theme-color">
                            <li class="theme-item"><a href="javascript:void(0)" class="theme-link" data-sidebarbg="skin1"></a></li>
                            <li class="theme-item"><a href="javascript:void(0)" class="theme-link" data-sidebarbg="skin2"></a></li>
                            <li class="theme-item"><a href="javascript:void(0)" class="theme-link" data-sidebarbg="skin3"></a></li>
                            <li class="theme-item"><a href="javascript:void(0)" class="theme-link" data-sidebarbg="skin4"></a></li>
                            <li class="theme-item"><a href="javascript:void(0)" class="theme-link" data-sidebarbg="skin5"></a></li>
                            <li class="theme-item"><a href="javascript:void(0)" class="theme-link" data-sidebarbg="skin6"></a></li>
                        </ul>
                        <!-- Logo BG -->
                    </div>
                </div>
                <!-- End Tab 1 -->
                <!-- Tab 2 -->
                <div class="tab-pane fade" id="chat" role="tabpanel" aria-labelledby="pills-profile-tab">
                    <ul class="mailbox list-style-none m-t-20">
                        <li>
                            <div class="message-center chat-scroll">
                                <a href="javascript:void(0)" class="message-item" id='chat_user_1' data-user-id='1'>
                                    <span class="user-img"> <img src="assets/images/users/1.jpg" alt="user" class="rounded-circle"> <span class="profile-status online pull-right"></span> </span>
                                    <div class="mail-contnet">
                                        <h5 class="message-title">Pavan kumar</h5> <span class="mail-desc">Just see the my admin!</span> <span class="time">9:30 AM</span> </div>
                                </a>
                                <!-- Message -->
                                <a href="javascript:void(0)" class="message-item" id='chat_user_2' data-user-id='2'>
                                    <span class="user-img"> <img src="assets/images/users/2.jpg" alt="user" class="rounded-circle"> <span class="profile-status busy pull-right"></span> </span>
                                    <div class="mail-contnet">
                                        <h5 class="message-title">Sonu Nigam</h5> <span class="mail-desc">I've sung a song! See you at</span> <span class="time">9:10 AM</span> </div>
                                </a>
                                <!-- Message -->
                                <a href="javascript:void(0)" class="message-item" id='chat_user_3' data-user-id='3'>
                                    <span class="user-img"> <img src="assets/images/users/3.jpg" alt="user" class="rounded-circle"> <span class="profile-status away pull-right"></span> </span>
                                    <div class="mail-contnet">
                                        <h5 class="message-title">Arijit Sinh</h5> <span class="mail-desc">I am a singer!</span> <span class="time">9:08 AM</span> </div>
                                </a>
                                <!-- Message -->
                                <a href="javascript:void(0)" class="message-item" id='chat_user_4' data-user-id='4'>
                                    <span class="user-img"> <img src="assets/images/users/4.jpg" alt="user" class="rounded-circle"> <span class="profile-status offline pull-right"></span> </span>
                                    <div class="mail-contnet">
                                        <h5 class="message-title">Nirav Joshi</h5> <span class="mail-desc">Just see the my admin!</span> <span class="time">9:02 AM</span> </div>
                                </a>
                                <!-- Message -->
                                <!-- Message -->
                                <a href="javascript:void(0)" class="message-item" id='chat_user_5' data-user-id='5'>
                                    <span class="user-img"> <img src="assets/images/users/5.jpg" alt="user" class="rounded-circle"> <span class="profile-status offline pull-right"></span> </span>
                                    <div class="mail-contnet">
                                        <h5 class="message-title">Sunil Joshi</h5> <span class="mail-desc">Just see the my admin!</span> <span class="time">9:02 AM</span> </div>
                                </a>
                                <!-- Message -->
                                <!-- Message -->
                                <a href="javascript:void(0)" class="message-item" id='chat_user_6' data-user-id='6'>
                                    <span class="user-img"> <img src="assets/images/users/6.jpg" alt="user" class="rounded-circle"> <span class="profile-status offline pull-right"></span> </span>
                                    <div class="mail-contnet">
                                        <h5 class="message-title">Akshay Kumar</h5> <span class="mail-desc">Just see the my admin!</span> <span class="time">9:02 AM</span> </div>
                                </a>
                                <!-- Message -->
                                <!-- Message -->
                                <a href="javascript:void(0)" class="message-item" id='chat_user_7' data-user-id='7'>
                                    <span class="user-img"> <img src="assets/images/users/7.jpg" alt="user" class="rounded-circle"> <span class="profile-status offline pull-right"></span> </span>
                                    <div class="mail-contnet">
                                        <h5 class="message-title">Pavan kumar</h5> <span class="mail-desc">Just see the my admin!</span> <span class="time">9:02 AM</span> </div>
                                </a>
                                <!-- Message -->
                                <!-- Message -->
                                <a href="javascript:void(0)" class="message-item" id='chat_user_8' data-user-id='8'>
                                    <span class="user-img"> <img src="assets/images/users/8.jpg" alt="user" class="rounded-circle"> <span class="profile-status offline pull-right"></span> </span>
                                    <div class="mail-contnet">
                                        <h5 class="message-title">Varun Dhavan</h5> <span class="mail-desc">Just see the my admin!</span> <span class="time">9:02 AM</span> </div>
                                </a>
                                <!-- Message -->
                            </div>
                        </li>
                    </ul>
                </div>
                <!-- End Tab 2 -->
                <!-- Tab 3 -->
                <div class="tab-pane fade p-15" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab">
                    <h6 class="m-t-20 m-b-20">Activity Timeline</h6>
                    <div class="steamline">
                        <div class="sl-item">
                            <div class="sl-left bg-success"> <i class="ti-user"></i></div>
                            <div class="sl-right">
                                <div class="font-medium">Meeting today <span class="sl-date"> 5pm</span></div>
                                <div class="desc">you can write anything </div>
                            </div>
                        </div>
                        <div class="sl-item">
                            <div class="sl-left bg-info"><i class="fas fa-image"></i></div>
                            <div class="sl-right">
                                <div class="font-medium">Send documents to Clark</div>
                                <div class="desc">Lorem Ipsum is simply </div>
                            </div>
                        </div>
                        <div class="sl-item">
                            <div class="sl-left"> <img class="rounded-circle" alt="user" src="assets/images/users/2.jpg"> </div>
                            <div class="sl-right">
                                <div class="font-medium">Go to the Doctor <span class="sl-date">5 minutes ago</span></div>
                                <div class="desc">Contrary to popular belief</div>
                            </div>
                        </div>
                        <div class="sl-item">
                            <div class="sl-left"> <img class="rounded-circle" alt="user" src="assets/images/users/1.jpg"> </div>
                            <div class="sl-right">
                                <div><a href="javascript:void(0)">Stephen</a> <span class="sl-date">5 minutes ago</span></div>
                                <div class="desc">Approve meeting with tiger</div>
                            </div>
                        </div>
                        <div class="sl-item">
                            <div class="sl-left bg-primary"> <i class="ti-user"></i></div>
                            <div class="sl-right">
                                <div class="font-medium">Meeting today <span class="sl-date"> 5pm</span></div>
                                <div class="desc">you can write anything </div>
                            </div>
                        </div>
                        <div class="sl-item">
                            <div class="sl-left bg-info"><i class="fas fa-image"></i></div>
                            <div class="sl-right">
                                <div class="font-medium">Send documents to Clark</div>
                                <div class="desc">Lorem Ipsum is simply </div>
                            </div>
                        </div>
                        <div class="sl-item">
                            <div class="sl-left"> <img class="rounded-circle" alt="user" src="assets/images/users/4.jpg"> </div>
                            <div class="sl-right">
                                <div class="font-medium">Go to the Doctor <span class="sl-date">5 minutes ago</span></div>
                                <div class="desc">Contrary to popular belief</div>
                            </div>
                        </div>
                        <div class="sl-item">
                            <div class="sl-left"> <img class="rounded-circle" alt="user" src="assets/images/users/6.jpg"> </div>
                            <div class="sl-right">
                                <div><a href="javascript:void(0)">Stephen</a> <span class="sl-date">5 minutes ago</span></div>
                                <div class="desc">Approve meeting with tiger</div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Tab 3 -->
            </div>
        </div>
    </aside>
    <div class="chat-windows"></div>
    <!-- ============================================================== -->
    <!-- All Jquery -->
    <!-- ============================================================== -->
    <script src="assets/libs/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="assets/libs/popper.js/dist/umd/popper.min.js"></script>
    <script src="assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- apps -->
    <script src="dist/js/app.min.js"></script>
    <script src="dist/js/app.init.dark.js"></script>
    <script src="dist/js/app-style-switcher.js"></script>
    <!-- slimscrollbar scrollbar JavaScript -->
    <script src="assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></script>
    <script src="assets/extra-libs/sparkline/sparkline.js"></script>
    <!--Wave Effects -->
    <script src="dist/js/waves.js"></script>
    <!--Menu sidebar -->
    <script src="dist/js/sidebarmenu.js"></script>
    <!--Custom JavaScript -->
    <script src="dist/js/custom.min.js"></script>
    <script src="assets/extra-libs/horizontal-timeline/horizontal-timeline.js"></script>
    <script src="assets/libs/pickadate/lib/compressed/picker.js"></script>
    <script src="assets/libs/pickadate/lib/compressed/picker.date.js"></script>
    <script src="assets/libs/pickadate/lib/compressed/picker.time.js"></script>
    <script src="assets/libs/pickadate/lib/compressed/legacy.js"></script>
    <script src="assets/libs/moment/moment.js"></script>
    <script src="assets/libs/daterangepicker/daterangepicker.js"></script>
    <script src="dist/js/pages/forms/datetimepicker/datetimepicker.init.js"></script>
    <script src="assets/libs/bootstrap-switch/dist/js/bootstrap-switch.min.js"></script>
    <script src="assets/libs/dropzone/dist/min/dropzone.min.js"></script>
    <script src="assets/libs/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
    <script>
    // Date Picker
    jQuery('.mydatepicker, #datepicker, .input-group.date').datepicker();
    jQuery('#datepicker-autoclose').datepicker({
        autoclose: true,
        todayHighlight: true
    });
    jQuery('#date-range').datepicker({
        toggleActive: true
    });
    jQuery('#datepicker-inline').datepicker({
        todayHighlight: true
    });
    </script>
    <script>
    $(".bt-switch input[type='checkbox'], .bt-switch input[type='radio']").bootstrapSwitch();
    var radioswitch = function() {
        var bt = function() {
            $(".radio-switch").on("switch-change", function() {
                $(".radio-switch").bootstrapSwitch("toggleRadioState")
            }), $(".radio-switch").on("switch-change", function() {
                $(".radio-switch").bootstrapSwitch("toggleRadioStateAllowUncheck")
            }), $(".radio-switch").on("switch-change", function() {
                $(".radio-switch").bootstrapSwitch("toggleRadioStateAllowUncheck", !1)
            })
        };
        return {
            init: function() {
                bt()
            }
        }
    }();
    $(document).ready(function() {
        radioswitch.init()
    });
    </script>
</body>


</html>

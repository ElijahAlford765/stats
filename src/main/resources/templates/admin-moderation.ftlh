<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Moderate Services & Users</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f8f9fa;
        }

        .container {
            margin-top: 30px;
        }

        .card {
            margin-bottom: 20px;
        }

        h3 {
            color: #ffffff;
            font-weight: bold;
        }

        .btn-approve {
            background-color: #28a745;
            color: white;
            border: none;
        }

        .btn-remove {
            background-color: #dc3545;
            color: white;
            border: none;
        }

        .btn-approve:hover, .btn-remove:hover {
            opacity: 0.8;
        }

        .checked {
            color: orange;
        }

        * {box-sizing: border-box;}
        ul {list-style-type: none;}
        body {font-family: Verdana, sans-serif;}

        .month {
            padding: 70px 25px;
            width: 100%;
            background: #1abc9c;
            text-align: center;
        }

        .month ul {
            margin: 0;
            padding: 0;
        }

        .month ul li {
            color: white;
            font-size: 20px;
            text-transform: uppercase;
            letter-spacing: 3px;
        }

        .month .prev {
            float: left;
            padding-top: 10px;
        }

        .month .next {
            float: right;
            padding-top: 10px;
        }

        .weekdays {
            margin: 0;
            padding: 10px 0;
            background-color: #ddd;
        }

        .weekdays li {
            display: inline-block;
            width: 13.6%;
            color: #666;
            text-align: center;
        }

        .days {
            padding: 10px 0;
            background: #eee;
            margin: 0;
        }

        .days li {
            list-style-type: none;
            display: inline-block;
            width: 13.6%;
            text-align: center;
            margin-bottom: 5px;
            font-size:12px;
            color: #777;
        }

        .days li .active {
            padding: 5px;
            background: #1abc9c;
            color: white !important
        }

        @media screen and (max-width:720px) {
            .weekdays li, .days li {width: 13.1%;}
        }

        @media screen and (max-width: 420px) {
            .weekdays li, .days li {width: 12.5%;}
            .days li .active {padding: 2px;}
        }

        @media screen and (max-width: 290px) {
            .weekdays li, .days li {width: 12.2%;}
        }
    </style>
</head>

<body>
<nav class="navbar navbar-dark bg-black">
    <div class="container">
        <a class="navbar-brand" href="dashboard">Admin Services</a>
    </div>
</nav>

<div class="container">
    <!-- Pending Services Section -->
    <section class="mb-5">
        <h2>Pending Services for Approval</h2>
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>ID</th><th>Title</th><th>Description</th><th>Provider</th><th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <#if services?has_content>
            <#list services as service>
            <tr>
                <td>${service.id}</td>
                <td>${service.title}</td>
                <td>${service.description}</td>
                <td>${service.user.userId}</td> <!-- Adjust as needed -->
                <td>
                    <form action="/stats/services/approve/${service.id}" method="post" style="display:inline;">
                        <button type="submit" class="btn btn-approve btn-sm">Approve</button>
                    </form>
                    <form method="post" action="/stats/services/delete/${service.id}" style="display:inline;">
                        <button class="btn btn-remove btn-sm" type="submit">Delete</button>
                    </form>
                </td>
            </tr>
            </#list>
            <#else>
            <tr><td colspan="5" class="text-center">No pending services found.</td></tr>
        </#if>
        </tbody>
        </table>
    </section>

    <!-- Flagged Services Section -->
    <section class="mb-5">
        <div class="card">
            <div class="card-header text-white bg-black">
                <h3>Flagged Services</h3>
            </div>
            <div class="card-body">
                <ul class="list-group">
                    <#if flaggedServices?has_content>
                    <#list flaggedServices as service>
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        ${service.name} - Reported by ${service.reportCount} users
                        <div>
                            <form method="post" action="/stats/services/delete/${service.id}" style="display:inline;">
                                <button class="btn btn-remove btn-sm" type="submit">Remove</button>
                            </form>
                            <form method="post" action="/stats/services/approve/${service.id}" style="display:inline;">
                                <button class="btn btn-approve btn-sm" type="submit">Reinstate</button>
                            </form>
                        </div>
                    </li>
                </#list>
                <#else>
                <li class="list-group-item text-center">No flagged services found.</li>
            </#if>
            </ul>
        </div>
</div>
</section>



<!-- User Management Section -->
<section class="mb-5">
    <h2>User Management</h2>
    <table class="table table-striped table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>ID</th><th>Username</th><th>Email</th><th>Role</th><th>Status</th><th>Admin</th>
        </tr>
        </thead>
        <tbody>
        <#if users?has_content>
        <#list users as user>
        <tr>
            <td>${user.userId}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.role}</td>
            <td>${user.status}</td>
            <td>${user.isAdmin?string("Yes", "No")}</td>
        </tr>
        </#list>
        <#else>
        <tr><td colspan="6" class="text-center">No users found.</td></tr>
    </#if>
    </tbody>
    </table>
</section>

<a href="/stats/dashboard" class="btn btn-secondary">Back to Dashboard</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


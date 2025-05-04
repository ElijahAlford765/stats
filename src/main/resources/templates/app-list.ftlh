<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Application Review</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css"/>
    <style>
        body {
            background-color: #f4f4f4;
        }
        .container {
            margin-top: 30px;
        }
        .card {
            padding: 20px;
            border-radius: 10px;
            margin-bottom: 30px;
        }
        .btn-approve {
            background-color: #28a745;
            color: white;
            border: none;
        }
        .btn-deny {
            background-color: #dc3545;
            color: white;
            border: none;
        }
        .btn-approve:hover, .btn-deny:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>

<!-- Navigation Bar -->
<nav class="navbar navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="/stats/dashboard">Admin Dashboard</a>
    </div>
</nav>

<div class="container">
    <#if applications?has_content>
    <#list applications as app>
    <div class="row">
        <div class="col-md-6">
            <div class="card">
                <h3 class="text-primary">Applicant Information</h3>
                <p><strong>Name:</strong> ${user.firstName} ${user.lastName}</p>
                <p><strong>Email:</strong> ${user.email}</p>
                <p><strong>Position Applied For:</strong> ${user.role}</p>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card">
                <h3 class="text-primary">Application Letter</h3>
                <blockquote class="blockquote">
                    <p>${proivder.about}</p>
                </blockquote>
                <div class="d-flex justify-content-between">
                    <button class="btn btn-approve" data-bs-toggle="modal" data-bs-target="#approveModal${app.applicationId}">Approve</button>
                    <button class="btn btn-deny" data-bs-toggle="modal" data-bs-target="#denyModal${app.applicationId}">Deny</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Approve Modal -->
    <div class="modal fade" id="approveModal${app.applicationId}" tabindex="-1" aria-labelledby="approveModalLabel${app.applicationId}" aria-hidden="true">
        <div class="modal-dialog">
            <form method="post" action="/stats/applications/approve/${app.applicationId}" class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="approveModalLabel${app.applicationId}">Approve Application</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Approve ${user.firstName} ${user.lastName}'s application?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-success">Confirm Approval</button>
                </div>
            </form>
        </div>
    </div>

    <!-- Deny Modal -->
    <div class="modal fade" id="denyModal${app.applicationId}" tabindex="-1" aria-labelledby="denyModalLabel${app.applicationId}" aria-hidden="true">
        <div class="modal-dialog">
            <form method="post" action="/stats/applications/deny/${app.applicationId}" class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="denyModalLabel${app.applicationId}">Deny Application</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Deny ${user.firstName} ${user.lastName}'s application?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger">Confirm Denial</button>
                </div>
            </form>
        </div>
    </div>
</#list>
<#else>
<div class="alert alert-info">No applications to review at the moment.</div>
</#if>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

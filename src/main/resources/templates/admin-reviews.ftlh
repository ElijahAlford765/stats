<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Panel</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Optional custom styles -->
    <style>
        .fa-star.checked {
            color: orange;
        }
    </style>
</head>

<body>
<div class="container mt-4">

    <!-- Dashboard Navigation -->
    <div class="row mb-3">
        <div class="col">
            <a href="/stats/dashboard" class="btn btn-primary">Back to Dashboard</a>
        </div>
    </div>

<!--    &lt;!&ndash; Notifications Section &ndash;&gt;-->
<!--    <div class="card mb-5">-->
<!--        <div class="card-header bg-dark text-white">-->
<!--            <h3>Notifications</h3>-->
<!--        </div>-->
<!--        <div class="card-body">-->
<!--            <ul class="list-group">-->
<!--                <#if notifications?has_content>-->
<!--                <#list notifications as note>-->
<!--                <li class="list-group-item">${note}</li>-->
<!--            </#list>-->
<!--            <#else>-->
<!--            <li class="list-group-item text-center">No new notifications.</li>-->
<!--        </#if>-->
<!--        </ul>-->
<!--    </div>-->
<!--</div>-->

<!-- Review Moderation Section -->
<div class="card mb-5">
    <div class="card-header bg-secondary text-white">
        <h3>Review Moderation</h3>
    </div>
    <div class="card-body">
        <ul class="list-group">
            <#if reviews?has_content>
            <#list reviews as review>
            <li class="list-group-item d-flex justify-content-between align-items-start flex-column flex-md-row">
                <div class="mb-2 mb-md-0">
                    <strong>${review.user.firstName} ${review.user.lastName}:</strong>
                    <blockquote>"${review.content}"</blockquote>
                    <#list 1..5 as i>
                    <span class="fa fa-star <#if i <= review.rating>checked</#if>"></span>
                </#list>
    </div>
    <div>
        <form action="/stats/reviews/approve/${review.id}" method="post" style="display:inline;">
            <button type="submit" class="btn btn-success btn-sm">Approve</button>
        </form>
        <form action="/stats/reviews/delete/${review.id}" method="post" style="display:inline;">
            <button type="submit" class="btn btn-danger btn-sm">Delete</button>
        </form>
        <form action="/stats/reviews/flag/${review.id}" method="post" style="display:inline;">
            <button type="submit" class="btn btn-warning btn-sm">Flag</button>
        </form>
    </div>
    </li>
</#list>
<#else>
<li class="list-group-item text-center">No reviews found.</li>
</#if>
</ul>
</div>
</div>

</div>

<!-- Bootstrap & FontAwesome JS (Optional for icons) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

</body>
</html>


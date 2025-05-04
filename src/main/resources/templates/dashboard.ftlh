<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SysAdmin Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css"/>
    <style>
        .sidebar {
            width: 250px;
            height: 100vh;
            background-color: #000;
            color: white;
            padding-top: 20px;
        }

        .sidebar .nav-link {
            color: white;
            font-weight: 500;
        }

        .sidebar .nav-link:hover {
            background-color: #343a40;
            border-radius: 5px;
        }

        .center-content {
            height: 100vh;
        }

        .welcome-section {
            background-image: url('https://clipart-library.com/images/6Ty5EXL6c.jpg');
            background-size: contain;
            background-repeat: no-repeat;
            background-position: center;
            padding: 50px;
            border-radius: 15px;
            background-color: rgba(255, 255, 255, 0.85);
        }

        .welcome-section h3,
        .welcome-section p {
            color: black;
        }
    </style>
</head>
<body>
<div class="d-flex">
    <!-- Sidebar Navigation -->
    <nav class="sidebar d-flex flex-column align-items-center p-3">
        <ul class="nav flex-column w-100 text-center">
            <li class="nav-item mb-2">
                <a class="nav-link" href="/stats/admin-moderation">Moderate Services</a>
            </li>
            <li class="nav-item mb-2">
                <a class="nav-link" href="/stats/reviews">Moderate Reviews</a>
            </li>
            <li class="nav-item mb-2">
                <a class="nav-link" href="/stats/users">Manage Users</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/stats/view">Statistics</a>
            </li>
        </ul>
    </nav>

    <!-- Welcome Content -->
    <div class="container-fluid d-flex justify-content-center align-items-center center-content">
        <div class="text-center welcome-section shadow-lg">
            <h3>Welcome to the PAW PAL Admin Dashboard</h3>
            <p>Manage services, users, and reports efficiently.</p>
        </div>
    </div>
</div>
</body>
</html>

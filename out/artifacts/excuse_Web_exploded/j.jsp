<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>模板页面</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        .container {
            width: 1000px;
            margin: 0 auto;
            border: 1px solid #000;
        }

        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px;
            border-bottom: 1px solid #000;
        }

        .logo {
            font-size: 24px;
            font-weight: bold;
        }

        .user-info {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px;
            border-bottom: 1px solid #000;
        }

        .datetime {
            font-size: 14px;
            text-align: right;
            border-bottom: 1px solid #000;
            padding: 10px;
        }

        nav {
            display: flex;
            justify-content: space-around;
            background-color: #f4f4f4;
            padding: 10px;
            border-bottom: 1px solid #000;
        }

        nav a {
            text-decoration: none;
            color: #000;
            padding: 5px 10px;
            border: 1px solid transparent;
        }

        nav a:hover {
            border: 1px solid #000;
        }

        .content {
            display: flex;
            padding: 20px;
            border-bottom: 1px solid #000;
        }

        aside {
            width: 30%;
            border-right: 1px solid #000;
            padding-right: 20px;
        }

        main {
            flex: 1;
            padding-left: 20px;
        }

        footer {
            border-top: 1px solid #000;
            text-align: center;
            padding: 10px;
        }

        @media (max-width: 768px) {
            .content {
                flex-direction: column;
            }

            aside {
                width: 100%;
                border-right: none;
                border-bottom: 1px solid #000;
                padding-right: 0;
                padding-bottom: 20px;
            }

            main {
                padding-left: 0;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <header>
        <div class="logo">Logo</div>
        <div class="datetime">
            2022-01-07 10:26:36 上午好！
        </div>
    </header>
    <div class="user-info">
        <div>当前用户: 张三 | <a href="#">退出</a>/<a href="#">登录</a></div>
    </div>
    <nav>
        <a href="#">新闻管理</a>
        <a href="#">评论管理</a>
        <a href="#">用户管理</a>
        <a href="#">首页</a>
    </nav>
    <div class="content">
        <aside>
            侧栏内容
        </aside>
        <main>
            页面主体内容
        </main>
    </div>
    <footer>
        页脚信息
    </footer>
</div>
</body>
</html>

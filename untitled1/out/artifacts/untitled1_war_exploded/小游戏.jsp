<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%
    // 获取会话中的游戏状态或初始化新的游戏
    Map<String, String> gameBoard = (Map<String, String>) session.getAttribute("gameBoard");
    String currentPlayer = (String) session.getAttribute("currentPlayer");
    String gameId = (String) session.getAttribute("gameId");
    String playerSymbol = (String) session.getAttribute("playerSymbol");
    String gameStatus = (String) session.getAttribute("gameStatus");

    // 如果是新游戏，则初始化游戏状态
    if (gameBoard == null) {
        gameBoard = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            gameBoard.put(String.valueOf(i), "");
        }
        session.setAttribute("gameBoard", gameBoard);
        currentPlayer = "X";
        session.setAttribute("currentPlayer", currentPlayer);
        gameId = UUID.randomUUID().toString();
        session.setAttribute("gameId", gameId);
        playerSymbol = "X"; // 第一个玩家是X
        session.setAttribute("playerSymbol", playerSymbol);
        gameStatus = "等待对手加入...";
        session.setAttribute("gameStatus", gameStatus);
    }

    // 处理玩家操作
    String action = request.getParameter("action");
    if ("move".equals(action)) {
        String position = request.getParameter("position");
        if (position != null && gameBoard.get(position).isEmpty()) {
            gameBoard.put(position, playerSymbol);
            session.setAttribute("gameBoard", gameBoard);

            // 检查是否有玩家获胜
            String winner = checkWinner(gameBoard);
            if (winner != null) {
                if (winner.equals(playerSymbol)) {
                    gameStatus = "恭喜你赢了!";
                } else if (!winner.isEmpty()) {
                    gameStatus = "对方获胜!";
                } else {
                    gameStatus = "平局!";
                }
                session.setAttribute("gameStatus", gameStatus);
            } else {
                // 切换当前玩家
                currentPlayer = currentPlayer.equals("X") ? "O" : "X";
                session.setAttribute("currentPlayer", currentPlayer);
                gameStatus = (currentPlayer.equals(playerSymbol) ? "轮到你下棋" : "等待对手下棋...");
                session.setAttribute("gameStatus", gameStatus);
            }
        }
    } else if ("reset".equals(action)) {
        // 重置游戏
        for (int i = 0; i < 9; i++) {
            gameBoard.put(String.valueOf(i), "");
        }
        session.setAttribute("gameBoard", gameBoard);
        currentPlayer = "X";
        session.setAttribute("currentPlayer", currentPlayer);
        gameStatus = "新游戏开始，X先手";
        session.setAttribute("gameStatus", gameStatus);
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>局域网井字棋游戏</title>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f0f0f0;
        }
        .game-container {
            max-width: 500px;
            margin: 50px auto;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
        }
        .game-info {
            margin: 20px 0;
            padding: 10px;
            background-color: #e9e9e9;
            border-radius: 5px;
        }
        .board {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            grid-gap: 10px;
            margin: 20px auto;
            max-width: 300px;
        }
        .cell {
            width: 100px;
            height: 100px;
            background-color: #fff;
            border: 2px solid #333;
            font-size: 48px;
            font-weight: bold;
            display: flex;
            align-items: center;
            justify-content: center;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .cell:hover {
            background-color: #f0f0f0;
        }
        .cell.x {
            color: #ff5252;
        }
        .cell.o {
            color: #4caf50;
        }
        button {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin: 10px;
        }
        button:hover {
            background-color: #45a049;
        }
        .player-symbol {
            font-size: 24px;
            font-weight: bold;
        }
        .player-x {
            color: #ff5252;
        }
        .player-o {
            color: #4caf50;
        }
    </style>
</head>
<body>
<div class="game-container">
    <h1>局域网井字棋游戏</h1>
    
    <div class="game-info">
        <p>你的标识: <span class="player-symbol player-<%= playerSymbol.toLowerCase() %>"><%= playerSymbol %></span></p>
        <p>游戏状态: <%= gameStatus %></p>
        <p>房间号: <%= gameId.substring(0, 8) %></p>
    </div>
    
    <div class="board">
        <% for (int i = 0; i < 9; i++) { %>
        <%
            String cellValue = gameBoard.get(String.valueOf(i));
            String cellClass = cellValue.isEmpty() ? "cell" : "cell " + cellValue.toLowerCase();
        %>
        <div class="<%= cellClass %>" onclick="makeMove(<%= i %>)">
            <%= cellValue %>
        </div>
        <% } %>
    </div>
    
    <button onclick="resetGame()">重新开始</button>
</div>

<script>
    function makeMove(position) {
        // 发送移动请求到服务器
        window.location.href = "小游戏.jsp?action=move&position=" + position;
    }
    
    function resetGame() {
        if (confirm("确定要重新开始游戏吗？")) {
            window.location.href = "小游戏.jsp?action=reset";
        }
    }
    
    // 每隔3秒自动刷新页面以获取最新的游戏状态
    setInterval(function() {
        if (document.querySelector('.cell') !== null) {
            window.location.reload();
        }
    }, 3000);
</script>
</body>
</html>

<%!
    // 检查是否有玩家获胜
    public String checkWinner(Map<String, String> board) {
        // 所有可能的获胜组合
        int[][] winPatterns = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // 行
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // 列
            {0, 4, 8}, {2, 4, 6}             // 对角线
        };
        
        for (int[] pattern : winPatterns) {
            String a = board.get(String.valueOf(pattern[0]));
            String b = board.get(String.valueOf(pattern[1]));
            String c = board.get(String.valueOf(pattern[2]));
            
            if (!a.isEmpty() && a.equals(b) && a.equals(c)) {
                return a; // 返回获胜玩家的符号
            }
        }
        
        // 检查是否平局
        boolean isFull = true;
        for (int i = 0; i < 9; i++) {
            if (board.get(String.valueOf(i)).isEmpty()) {
                isFull = false;
                break;
            }
        }
        
        if (isFull) {
            return ""; // 平局
        }
        
        return null; // 游戏继续
    }
%>
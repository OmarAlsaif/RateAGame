<%@page contentType="text/html;charset=UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>RAG</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="../../css/style.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="../../js/script.js"></script>
    <link rel="shortcut icon" href="../../img/RAG logo.png">
    <link rel="stylesheet" type="text/css" media="screen" href="../../css/animate.css" />
    <link href="https://fonts.googleapis.com/css?family=Gloria+Hallelujah" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Nanum+Brush+Script" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Rubik" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Cinzel' rel='stylesheet'>

</head>

<body>
    <header>
        <nav id="navigation">
            <a href="../../index.jsp" id="title">Rate A Game</a>
            <a href="../../index.jsp"><img id="logo" src="../../img/RAG logo.png" /></a>
            <input type="search" id="searchbar" placeholder="Search here...">
            <div id="menu">
                <ul>
                    <li><a href=<%
				String username2 = (String)session.getAttribute("loginName");
				if (null != username2) {
					out.print("../../LogOutServlet"); 
				} else {
					out.print("../../login.html");
				}
				%>
				>	
				<%
					System.out.println(session);
					String str = (String) session.getAttribute("loginName");
					System.out.println(session);
					if (null != username2) {
						out.print("Logout");
					    } else {
					    	out.print("Sign In");
					    }					
				%>	</a></li>
                    <li class="active"><a href="../../top10.jsp">Top 10</a></li>
                    <li><a href="../../news.jsp">News</a></li>
                    <li class="slide"></li>
                </ul>
            </div>
        </nav>
    </header>
    <div id="wrapper">
        <div id="titlehead">
            <img src="acreed.jpg" alt="Assasins Creed Odyssey Head Cover">
            <div id="titlehead-text">
                Assasins Creed Odyssey
            </div>
        </div>
        <article id="titlecontainer">
            <img src="acreedcover.jpg" alt="Asssins Creed Odyssey Front Cover">
            <div id="titlecontent">
                <div id="titlecontent-headline">
                    <h2>
                        Assasins Creed Odyssey
                    </h2>
                    <h2>
                    
                        Rating: <% 
                        
                        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
            					"password");
                        Statement st = con.createStatement();
            			ResultSet rs = st.executeQuery("select * from acodyssey");

						int columnName2 = 0;
						int i = 0;
            			 while(rs.next())
            		        {
            	        columnName2+= rs.getInt("rating");
						i++;
            		        }
   
              	        out.print(columnName2/i + "/10");
                        
                        %>
                    </h2>
                </div>
                
                  <form action="../../RatingServlet" method="post">     
               	 <div class="rate">                   	             
                    <input type="radio" id="star10" name="rate" value="10" />
                    <label for="star10" title="text">10 stars</label>
                    <input type="radio" id="star9" name="rate" value="9" />
                    <label for="star9" title="text">9 stars</label>
                    <input type="radio" id="star8" name="rate" value="8" />
                    <label for="star8" title="text">8 stars</label>
                    <input type="radio" id="star7" name="rate" value="7" />
                    <label for="star7" title="text">7 stars</label>
                    <input type="radio" id="star6" name="rate" value="6" />
                    <label for="star6" title="text">6 star</label>
                    <input type="radio" id="star5" name="rate" value="5" />
                    <label for="star5" title="text">5 stars</label>
                    <input type="radio" id="star4" name="rate" value="4" />
                    <label for="star4" title="text">4 stars</label>
                    <input type="radio" id="star3" name="rate" value="3" />
                    <label for="star3" title="text">3 stars</label>
                    <input type="radio" id="star2" name="rate" value="2" />
                    <label for="star2" title="text">2 stars</label>
                    <input type="radio" id="star1" name="rate" value="1" />
                    <label for="star1" title="text">1 star</label>
                    <div class="containerbtn">
                    <button type="submit" id="votebutton" value="Vote" <%
            				String username = (String)session.getAttribute("loginName");
            				if (null == username) {
            					out.print("disabled");
            				}
					%>>
                    

                    
                            <span>
                                Vote!    
                            </span>
                        </button>
                    </div>
                </div>
                </form>
                 
                <div class="discription">
                    <p>
                        
                    </p>
                    <p>
                        Link to official site: <a href="https://assassinscreed.ubisoft.com/game/en-gb/home" target="_blank">Assasins
                            Creed Odyssey</a>
                    </p>
                </div>

            </div>
            <div id="titleinfo">

                <p>Publishers: </p>
                <p>Releasedate:</p>
                <p>Genre: </p>
                <p>Game Modes: </p>
                <p>Player Perspectives: </p>
                </p>
            </div>
        </article>
        <div id="co-titlecontent">
            <iframe src="https://www.youtube.com/embed/jiX2Xo6gzwo" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                allowfullscreen class="co-titlecontent-img"></iframe>
            <img src="https://gematsu.com/wp-content/uploads/2018/08/ACO_08-21-18.jpg" class="co-titlecontent-img" alt="">
            <img src="https://www.pcgamesn.com/wp-content/uploads/2018/10/assassins-creed-odyssey-historically-accurate-900x507.png"
                class="co-titlecontent-img">
            <img src="https://static.trueachievements.com/customimages/087640.jpg" class="co-titlecontent-img">
        </div>
        <div id="review-section">
            <h2>Leave a comment about the game:</h2>
            <div class="titleform">
                <label for="name">Name: </label>
                <input type="text" id="name"><br>
                <label for="date">Date: </label>
                <input type="date" id="date"><br>
                <label for="bodytext">Text: </label>
                <textarea rows="5" cols="30" id="bodytext"></textarea><br>
                <input type="button" id="addComment" value="Add Comment">
            </div>
            <div id="container">    
                
            </div>
        </div>
    </div>
    <footer>
        <p>
            Projektgrupp 6<br> Copyright 2019
        </p>
    </footer>

</body>

</html>
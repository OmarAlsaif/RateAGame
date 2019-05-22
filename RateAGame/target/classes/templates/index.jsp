<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>RAG</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="css/style.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script language="JavaScript" type="text/javascript" src="https://code.jquery.com/jquery-3.4.0.js"></script>
    <link rel="stylesheet" type="text/css" media="screen" href="css/animate.css" />
    <link href="https://fonts.googleapis.com/css?family=Gloria+Hallelujah" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Nanum+Brush+Script" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Rubik" rel="stylesheet">
    <link rel="shortcut icon" href="img/RAG logo.png">
    <link href="https://fonts.googleapis.com/css?family=Gugi" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <link rel="stylesheet" href="css/preload.css">
	<script src="js/js libary/modernizr-2.6.2.min.js"></script>
</head>

<body>
     <header>
        <nav id="navigation">
            <a href="index.jsp" id="title">Rate A Game</a>
            <a href="index.jsp"><img id="logo" src="img/RAG logo.png" /></a>
            <input type="search" id="searchbar" placeholder="Search here...">
            <div id="menu">
                <ul>
                    <li><a href=<%
				String username2 = (String)session.getAttribute("loginName");
				if (null != username2) {
					out.print("LogOutServlet"); 
				} else {
					out.print("login.html");
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
                    <li><a href="top10.jsp">Top 10</a></li>
                    <li><a href="news.jsp">News</a></li>
                    <li class="slide"></li>
                </ul>
            </div>
        </nav>
    </header>
    <div id="mainwrap">
        <div id="left-container">
            <h2>
                            Top games right now:
            </h2>
            <p>
                            Apex Legends
            </p>
            <p>
                            Resident Evil 2
            </p>
            <p>
                            Devil May Cry 5
            </p>
            <p>
                            Mortal Combat 11
            </p>
                
        </div>
      
 
       
            
            <div id="middle-container">
                    
                    <i class="fas fa-chevron-right" id="nextBtn"></i>
                    <i class="fas fa-chevron-left" id="prevBtn"></i>
            <div class="slide-container">
                    <img src="img/fallout76.jpg" id="lastClone" alt="">
                 <section>
                     <div id="imgx_text">
                            <p>
                                    "Re-live the wild west!"
                                         
                                    </p>
                                    <button>
                                        Read more
                                    </button>


                     </div>
                 </section>   
                  
                <img src="img/rdr2.jpg" id="rdr2" alt=" Red dead redemption game poster">
                <section>
                    <div id="img1_text">
                            <p>
                                "Earth is ours no more!"
                                     
                                </p>
                                <button>
                                    Read more
                                </button>
                    </div>
                </section>
                <img src="img/horizonzerodawn.jpg" id="horizon" alt= "horizonzerodawn game poster">
                <section>
                    <div id="img2_text">
                            <p>
                                    "Welcome to wild Appalachia!"
                                   
                                </p>
                                <button>
                                    Read more
                                </button>
                    </div>
                </section>
                <img src="img/fallout76.jpg" id="fallout" alt="Fallout game poster">
                <img src="img/rdr2.jpg" id="firstClone" alt="">
                <section>
                    <div id="img3_text">
                    </div>

                </section>
                        
                </div>
                </div>
                
                <div id="middle-second">
                    <p>
                        <a href="titles/diablo3/diablo3.html"><img src="Titles/Diablo 3/diablo3cover.jpg"
                        alt="Diablo 3 Cover"></a>
                        Diablo 3
                    </p>
                    <p>
                        <a href="titles/gta5/gta5.html"><img src="Titles/GTA5/gta5cover.jpg" alt="GTA 5 Cover"></a>
                        GTA 5
                    </p>
                    <p>
                        <a href="titles/anthem/anthem.html"><img src="Titles/Anthem/anthemcover.jpeg"
                                alt="Anthem Cover"></a>
                        Anthem
                    </p>
                    <p>
                        <a href="titles/farcry new dawn/farcrynewdawn.html"><img src="Titles/FarCry New Dawn/farcrynewdawncover.jpg" alt="Farcry New Dawn Cover"></a>
                        FarCry New Dawn
                    </p>
                    <p>
                        <a href="titles/battlefield 5/battlefield5.html"><img
                                src="Titles/Battlefield 5/Battlefield5cover.jpg" alt="Battlefield 5 Cover"></a>
                        Battlefield 5
                    </p>
                    <p>
                        <a href="titles/Apex Legends/apexlegends.html"><img
                                src="Titles/Apex Legends/538006-apex-legends-xbox-one-front-cover.jpg" alt="apexlegends cover"></a>
                                Apex Legends
                    </p>
                    <p>
                        <a href="titles/MortalCombat11/mortalkombat11.html"><img
                                src="Titles/MortalCombat11/220px-Mortal_Kombat_11_cover_art.png" alt="mortal kombat 11 cover"></a>
                                Mortal Combat XI
                    </p>
                    <p>
                        <a href="titles/MertroExodus/metroexodus.html"><img
                                src="Titles/MertroExodus/220px-Cover_Art_of_Metro_Exodus.png" alt="metroexodus cover"></a>
                                Metro Exodus
                    </p>
                   
        
                    
            </div>
            <div id="right-container">
                <h2>
                    Recent reviews:
                   
                </h2>
            </div>
            <div id="bottom-container">
                <h2>Latest news: </h2>
                <p>
                    <a href="https://www.cyberockk.com/2019/05/hitman-hd-pack-now-available-to-xbox-one-backward-compatibility/">
                        <img class="LatestNewsImg" src="img/Hitman-HD-Pack.jpg">
                        Hitman HD Pack Now Available to Xbox One Backward Compatibility</a>
                </p>
                <p>
                    <a href="https://twinfinite.net/2019/05/this-video-gives-detective-pikachu-a-retro-game-boy-color-de-make/">
                        <img class="LatestNewsImg" src="img/DetectivePikachu_Logo_Final_EN_BlkTM.png">
                        This Video Gives Detective Pikachu a Retro Game Boy Color De-Make</a>
                </p>
                <p>
                    <a href="https://www.rockpapershotgun.com/2019/05/09/life-is-strange-2-episode-3-released/?utm_source=feedburner&utm_medium=feed&utm_campaign=Feed%3A+RockPaperShotgun+%28Rock%2C+Paper%2C+Shotgun%29">
                        <img class="LatestNewsImg" src="img/lis2.png">
                        Life Is Strange 2 episode 3 now rumbling in the redwoods</a>
                </p>
            </div>
        </div>

    
        <div id="loader-wrapper">
			<div id="loader"></div>

			<div class="loader-section section-left"></div>
            <div class="loader-section section-right"></div>

        </div>
        
    </div>
    <footer>
        <p>
            Projektgrupp 6<br> Copyright 2019
        </p>
    </footer>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="js/js libary/jquery-1.9.1.min.js"><\/script>')</script>
    <script src="js/preload.js"></script>
    <script src="js/script.js"></script>
    <script src="js/headerFunction.js"></script>

    
</body>

</html>
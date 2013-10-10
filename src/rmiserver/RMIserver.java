


<!DOCTYPE html>
<html>
  <head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# githubog: http://ogp.me/ns/fb/githubog#">
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>RPC/src/rmiserver/RMIserver.java at master · galaxiz/RPC</title>
    <link rel="search" type="application/opensearchdescription+xml" href="/opensearch.xml" title="GitHub" />
    <link rel="fluid-icon" href="https://github.com/fluidicon.png" title="GitHub" />
    <link rel="apple-touch-icon" sizes="57x57" href="/apple-touch-icon-114.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="/apple-touch-icon-114.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="/apple-touch-icon-144.png" />
    <link rel="apple-touch-icon" sizes="144x144" href="/apple-touch-icon-144.png" />
    <link rel="logo" type="image/svg" href="https://github-media-downloads.s3.amazonaws.com/github-logo.svg" />
    <meta property="og:image" content="https://github.global.ssl.fastly.net/images/modules/logos_page/Octocat.png">
    <meta name="hostname" content="github-fe132-cp1-prd.iad.github.net">
    <meta name="ruby" content="ruby 1.9.3p194-tcs-github-tcmalloc (2012-05-25, TCS patched 2012-05-27, GitHub v1.0.36) [x86_64-linux]">
    <link rel="assets" href="https://github.global.ssl.fastly.net/">
    <link rel="conduit-xhr" href="https://ghconduit.com:25035/">
    <link rel="xhr-socket" href="/_sockets" />
    


    <meta name="msapplication-TileImage" content="/windows-tile.png" />
    <meta name="msapplication-TileColor" content="#ffffff" />
    <meta name="selected-link" value="repo_source" data-pjax-transient />
    <meta content="collector.githubapp.com" name="octolytics-host" /><meta content="github" name="octolytics-app-id" /><meta content="80ED80E2:1FA6:C24DE7D:52560FAD" name="octolytics-dimension-request_id" /><meta content="3090908" name="octolytics-actor-id" /><meta content="galaxiz" name="octolytics-actor-login" /><meta content="16ff716cc8aee5551207160228f9f27540865aca894ad71ef04679242519bbcc" name="octolytics-actor-hash" />
    

    
    
    <link rel="icon" type="image/x-icon" href="/favicon.ico" />

    <meta content="authenticity_token" name="csrf-param" />
<meta content="rDZoJF5heAR60s9+u0k2RH1YE1nuhg5CCt9MXh/MTTA=" name="csrf-token" />

    <link href="https://github.global.ssl.fastly.net/assets/github-da610086a8ece032a05fc6706ebe8776de27cc3f.css" media="all" rel="stylesheet" type="text/css" />
    <link href="https://github.global.ssl.fastly.net/assets/github2-d20fd2cce9c0d29564dc2dd07ba7115cf00ea07a.css" media="all" rel="stylesheet" type="text/css" />
    

    

      <script src="https://github.global.ssl.fastly.net/assets/frameworks-3e962e599763b7c5f9668b8c1f3a968b7ebf72e9.js" type="text/javascript"></script>
      <script src="https://github.global.ssl.fastly.net/assets/github-70ee8f16d71727d95df4113a25fedb1e9ba31fe7.js" type="text/javascript"></script>
      
      <meta http-equiv="x-pjax-version" content="020ad5edb62a36dda0ed561858cca042">

        <link data-pjax-transient rel='permalink' href='/galaxiz/RPC/blob/542ea799db150ed94f77fd8b440f6fd95392ce35/src/rmiserver/RMIserver.java'>
  <meta property="og:title" content="RPC"/>
  <meta property="og:type" content="githubog:gitrepository"/>
  <meta property="og:url" content="https://github.com/galaxiz/RPC"/>
  <meta property="og:image" content="https://github.global.ssl.fastly.net/images/gravatars/gravatar-user-420.png"/>
  <meta property="og:site_name" content="GitHub"/>
  <meta property="og:description" content="XML-based RPC"/>

  <meta name="description" content="XML-based RPC" />

  <meta content="3090908" name="octolytics-dimension-user_id" /><meta content="galaxiz" name="octolytics-dimension-user_login" /><meta content="12913071" name="octolytics-dimension-repository_id" /><meta content="galaxiz/RPC" name="octolytics-dimension-repository_nwo" /><meta content="false" name="octolytics-dimension-repository_public" /><meta content="false" name="octolytics-dimension-repository_is_fork" /><meta content="12913071" name="octolytics-dimension-repository_network_root_id" /><meta content="galaxiz/RPC" name="octolytics-dimension-repository_network_root_nwo" />
  <link href="https://github.com/galaxiz/RPC/commits/master.atom?login=galaxiz&token=e42ce621f75cf01fda40ee0c553d668a" rel="alternate" title="Recent Commits to RPC:master" type="application/atom+xml" />

  </head>


  <body class="logged_in  env-production linux vis-private  page-blob">
    <div class="wrapper">
      
      
      


      <div class="header header-logged-in true">
  <div class="container clearfix">

    <a class="header-logo-invertocat" href="https://github.com/">
  <span class="mega-octicon octicon-mark-github"></span>
</a>

    
    <a href="/notifications" class="notification-indicator tooltipped downwards" data-gotokey="n" title="You have unread notifications">
        <span class="mail-status unread"></span>
</a>

      <div class="command-bar js-command-bar  in-repository">
          <form accept-charset="UTF-8" action="/search" class="command-bar-form" id="top_search_form" method="get">

<input type="text" data-hotkey="/ s" name="q" id="js-command-bar-field" placeholder="Search or type a command" tabindex="1" autocapitalize="off"
    
    data-username="galaxiz"
      data-repo="galaxiz/RPC"
      data-branch="master"
      data-sha="250a4bcccf4010b36069a4c71b7cd9b53aa3609f"
  >

    <input type="hidden" name="nwo" value="galaxiz/RPC" />

    <div class="select-menu js-menu-container js-select-menu search-context-select-menu">
      <span class="minibutton select-menu-button js-menu-target">
        <span class="js-select-button">This repository</span>
      </span>

      <div class="select-menu-modal-holder js-menu-content js-navigation-container">
        <div class="select-menu-modal">

          <div class="select-menu-item js-navigation-item js-this-repository-navigation-item selected">
            <span class="select-menu-item-icon octicon octicon-check"></span>
            <input type="radio" class="js-search-this-repository" name="search_target" value="repository" checked="checked" />
            <div class="select-menu-item-text js-select-button-text">This repository</div>
          </div> <!-- /.select-menu-item -->

          <div class="select-menu-item js-navigation-item js-all-repositories-navigation-item">
            <span class="select-menu-item-icon octicon octicon-check"></span>
            <input type="radio" name="search_target" value="global" />
            <div class="select-menu-item-text js-select-button-text">All repositories</div>
          </div> <!-- /.select-menu-item -->

        </div>
      </div>
    </div>

  <span class="octicon help tooltipped downwards" title="Show command bar help">
    <span class="octicon octicon-question"></span>
  </span>


  <input type="hidden" name="ref" value="cmdform">

</form>
        <ul class="top-nav">
          <li class="explore"><a href="/explore">Explore</a></li>
            <li><a href="https://gist.github.com">Gist</a></li>
            <li><a href="/blog">Blog</a></li>
          <li><a href="https://help.github.com">Help</a></li>
        </ul>
      </div>

    


  <ul id="user-links">
    <li>
      <a href="/galaxiz" class="name">
        <img height="20" src="https://0.gravatar.com/avatar/2cf0b6a3df23b73c7ae09e2a88d2ceaa?d=https%3A%2F%2Fidenticons.github.com%2F6d3292d5a7e1d8f87db8805343d77261.png&amp;s=140" width="20" /> galaxiz
      </a>
    </li>

      <li>
        <a href="/new" id="new_repo" class="tooltipped downwards" title="Create a new repo" aria-label="Create a new repo">
          <span class="octicon octicon-repo-create"></span>
        </a>
      </li>

      <li>
        <a href="/settings/profile" id="account_settings"
          class="tooltipped downwards"
          aria-label="Account settings "
          title="Account settings ">
          <span class="octicon octicon-tools"></span>
        </a>
      </li>
      <li>
        <a class="tooltipped downwards" href="/logout" data-method="post" id="logout" title="Sign out" aria-label="Sign out">
          <span class="octicon octicon-log-out"></span>
        </a>
      </li>

  </ul>

<div class="js-new-dropdown-contents hidden">
  

<ul class="dropdown-menu">
  <li>
    <a href="/new"><span class="octicon octicon-repo-create"></span> New repository</a>
  </li>
  <li>
    <a href="/organizations/new"><span class="octicon octicon-organization"></span> New organization</a>
  </li>



    <li class="section-title">
      <span title="galaxiz/RPC">This repository</span>
    </li>
    <li>
      <a href="/galaxiz/RPC/issues/new"><span class="octicon octicon-issue-opened"></span> New issue</a>
    </li>
      <li>
        <a href="/galaxiz/RPC/settings/collaboration"><span class="octicon octicon-person-add"></span> New collaborator</a>
      </li>
</ul>

</div>


    
  </div>
</div>

      

      




          <div class="site" itemscope itemtype="http://schema.org/WebPage">
    
    <div class="pagehead repohead instapaper_ignore readability-menu">
      <div class="container">
        

<ul class="pagehead-actions">

    <li class="subscription">
      <form accept-charset="UTF-8" action="/notifications/subscribe" class="js-social-container" data-autosubmit="true" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="authenticity_token" type="hidden" value="rDZoJF5heAR60s9+u0k2RH1YE1nuhg5CCt9MXh/MTTA=" /></div>  <input id="repository_id" name="repository_id" type="hidden" value="12913071" />

    <div class="select-menu js-menu-container js-select-menu">
      <a class="social-count js-social-count" href="/galaxiz/RPC/watchers">
        2
      </a>
      <span class="minibutton select-menu-button with-count js-menu-target" role="button" tabindex="0">
        <span class="js-select-button">
          <span class="octicon octicon-eye-unwatch"></span>
          Unwatch
        </span>
      </span>

      <div class="select-menu-modal-holder">
        <div class="select-menu-modal subscription-menu-modal js-menu-content">
          <div class="select-menu-header">
            <span class="select-menu-title">Notification status</span>
            <span class="octicon octicon-remove-close js-menu-close"></span>
          </div> <!-- /.select-menu-header -->

          <div class="select-menu-list js-navigation-container" role="menu">

            <div class="select-menu-item js-navigation-item " role="menuitem" tabindex="0">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <div class="select-menu-item-text">
                <input id="do_included" name="do" type="radio" value="included" />
                <h4>Not watching</h4>
                <span class="description">You only receive notifications for discussions in which you participate or are @mentioned.</span>
                <span class="js-select-button-text hidden-select-button-text">
                  <span class="octicon octicon-eye-watch"></span>
                  Watch
                </span>
              </div>
            </div> <!-- /.select-menu-item -->

            <div class="select-menu-item js-navigation-item selected" role="menuitem" tabindex="0">
              <span class="select-menu-item-icon octicon octicon octicon-check"></span>
              <div class="select-menu-item-text">
                <input checked="checked" id="do_subscribed" name="do" type="radio" value="subscribed" />
                <h4>Watching</h4>
                <span class="description">You receive notifications for all discussions in this repository.</span>
                <span class="js-select-button-text hidden-select-button-text">
                  <span class="octicon octicon-eye-unwatch"></span>
                  Unwatch
                </span>
              </div>
            </div> <!-- /.select-menu-item -->

            <div class="select-menu-item js-navigation-item " role="menuitem" tabindex="0">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <div class="select-menu-item-text">
                <input id="do_ignore" name="do" type="radio" value="ignore" />
                <h4>Ignoring</h4>
                <span class="description">You do not receive any notifications for discussions in this repository.</span>
                <span class="js-select-button-text hidden-select-button-text">
                  <span class="octicon octicon-mute"></span>
                  Stop ignoring
                </span>
              </div>
            </div> <!-- /.select-menu-item -->

          </div> <!-- /.select-menu-list -->

        </div> <!-- /.select-menu-modal -->
      </div> <!-- /.select-menu-modal-holder -->
    </div> <!-- /.select-menu -->

</form>
    </li>

  <li>
  
<div class="js-toggler-container js-social-container starring-container ">
  <a href="/galaxiz/RPC/unstar" class="minibutton with-count js-toggler-target star-button starred upwards" title="Unstar this repo" data-remote="true" data-method="post" rel="nofollow">
    <span class="octicon octicon-star-delete"></span><span class="text">Unstar</span>
  </a>
  <a href="/galaxiz/RPC/star" class="minibutton with-count js-toggler-target star-button unstarred upwards" title="Star this repo" data-remote="true" data-method="post" rel="nofollow">
    <span class="octicon octicon-star"></span><span class="text">Star</span>
  </a>
  <a class="social-count js-social-count" href="/galaxiz/RPC/stargazers">0</a>
</div>

  </li>


        <li>
          <a href="/galaxiz/RPC/fork" class="minibutton with-count js-toggler-target fork-button lighter upwards" title="Fork this repo" rel="nofollow" data-method="post">
            <span class="octicon octicon-git-branch-create"></span><span class="text">Fork</span>
          </a>
          <a href="/galaxiz/RPC/network" class="social-count">0</a>
        </li>


</ul>

        <h1 itemscope itemtype="http://data-vocabulary.org/Breadcrumb" class="entry-title private">
          <span class="repo-label"><span>private</span></span>
          <span class="mega-octicon octicon-lock"></span>
          <span class="author">
            <a href="/galaxiz" class="url fn" itemprop="url" rel="author"><span itemprop="title">galaxiz</span></a></span
          ><span class="repohead-name-divider">/</span><strong
          ><a href="/galaxiz/RPC" class="js-current-repository js-repo-home-link">RPC</a></strong>

          <span class="page-context-loader">
            <img alt="Octocat-spinner-32" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
          </span>

        </h1>
      </div><!-- /.container -->
    </div><!-- /.repohead -->

    <div class="container">

      <div class="repository-with-sidebar repo-container ">

        <div class="repository-sidebar">
            

<div class="repo-nav repo-nav-full js-repository-container-pjax js-octicon-loaders">
  <div class="repo-nav-contents">
    <ul class="repo-menu">
      <li class="tooltipped leftwards" title="Code">
        <a href="/galaxiz/RPC" aria-label="Code" class="js-selected-navigation-item selected" data-gotokey="c" data-pjax="true" data-selected-links="repo_source repo_downloads repo_commits repo_tags repo_branches /galaxiz/RPC">
          <span class="octicon octicon-code"></span> <span class="full-word">Code</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

        <li class="tooltipped leftwards" title="Issues">
          <a href="/galaxiz/RPC/issues" aria-label="Issues" class="js-selected-navigation-item js-disable-pjax" data-gotokey="i" data-selected-links="repo_issues /galaxiz/RPC/issues">
            <span class="octicon octicon-issue-opened"></span> <span class="full-word">Issues</span>
            <span class='counter'>0</span>
            <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>        </li>

      <li class="tooltipped leftwards" title="Pull Requests"><a href="/galaxiz/RPC/pulls" aria-label="Pull Requests" class="js-selected-navigation-item js-disable-pjax" data-gotokey="p" data-selected-links="repo_pulls /galaxiz/RPC/pulls">
            <span class="octicon octicon-git-pull-request"></span> <span class="full-word">Pull Requests</span>
            <span class='counter'>0</span>
            <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>


        <li class="tooltipped leftwards" title="Wiki">
          <a href="/galaxiz/RPC/wiki" aria-label="Wiki" class="js-selected-navigation-item " data-pjax="true" data-selected-links="repo_wiki /galaxiz/RPC/wiki">
            <span class="octicon octicon-book"></span> <span class="full-word">Wiki</span>
            <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>        </li>
    </ul>
    <div class="repo-menu-separator"></div>
    <ul class="repo-menu">

      <li class="tooltipped leftwards" title="Pulse">
        <a href="/galaxiz/RPC/pulse" aria-label="Pulse" class="js-selected-navigation-item " data-pjax="true" data-selected-links="pulse /galaxiz/RPC/pulse">
          <span class="octicon octicon-pulse"></span> <span class="full-word">Pulse</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

      <li class="tooltipped leftwards" title="Graphs">
        <a href="/galaxiz/RPC/graphs" aria-label="Graphs" class="js-selected-navigation-item " data-pjax="true" data-selected-links="repo_graphs repo_contributors /galaxiz/RPC/graphs">
          <span class="octicon octicon-graph"></span> <span class="full-word">Graphs</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

      <li class="tooltipped leftwards" title="Network">
        <a href="/galaxiz/RPC/network" aria-label="Network" class="js-selected-navigation-item js-disable-pjax" data-selected-links="repo_network /galaxiz/RPC/network">
          <span class="octicon octicon-git-branch"></span> <span class="full-word">Network</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>
    </ul>


      <div class="repo-menu-separator"></div>
      <ul class="repo-menu">
        <li class="tooltipped leftwards" title="Settings">
          <a href="/galaxiz/RPC/settings" data-pjax aria-label="Settings">
            <span class="octicon octicon-tools"></span> <span class="full-word">Settings</span>
            <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
          </a>
        </li>
      </ul>
  </div>
</div>

            <div class="only-with-full-nav">
              

  

<div class="clone-url open"
  data-protocol-type="http"
  data-url="/users/set_protocol?protocol_selector=http&amp;protocol_type=push">
  <h3><strong>HTTPS</strong> clone URL</h3>
  <div class="clone-url-box">
    <input type="text" class="clone js-url-field"
           value="https://github.com/galaxiz/RPC.git" readonly="readonly">

    <span class="js-zeroclipboard url-box-clippy minibutton zeroclipboard-button" data-clipboard-text="https://github.com/galaxiz/RPC.git" data-copied-hint="copied!" title="copy to clipboard"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>

  

<div class="clone-url "
  data-protocol-type="ssh"
  data-url="/users/set_protocol?protocol_selector=ssh&amp;protocol_type=push">
  <h3><strong>SSH</strong> clone URL</h3>
  <div class="clone-url-box">
    <input type="text" class="clone js-url-field"
           value="git@github.com:galaxiz/RPC.git" readonly="readonly">

    <span class="js-zeroclipboard url-box-clippy minibutton zeroclipboard-button" data-clipboard-text="git@github.com:galaxiz/RPC.git" data-copied-hint="copied!" title="copy to clipboard"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>

  

<div class="clone-url "
  data-protocol-type="subversion"
  data-url="/users/set_protocol?protocol_selector=subversion&amp;protocol_type=push">
  <h3><strong>Subversion</strong> checkout URL</h3>
  <div class="clone-url-box">
    <input type="text" class="clone js-url-field"
           value="https://github.com/galaxiz/RPC" readonly="readonly">

    <span class="js-zeroclipboard url-box-clippy minibutton zeroclipboard-button" data-clipboard-text="https://github.com/galaxiz/RPC" data-copied-hint="copied!" title="copy to clipboard"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>


<p class="clone-options">You can clone with
      <a href="#" class="js-clone-selector" data-protocol="http">HTTPS</a>,
      <a href="#" class="js-clone-selector" data-protocol="ssh">SSH</a>,
      or <a href="#" class="js-clone-selector" data-protocol="subversion">Subversion</a>.
  <span class="octicon help tooltipped upwards" title="Get help on which URL is right for you.">
    <a href="https://help.github.com/articles/which-remote-url-should-i-use">
    <span class="octicon octicon-question"></span>
    </a>
  </span>
</p>



              <a href="/galaxiz/RPC/archive/master.zip"
                 class="minibutton sidebar-button"
                 title="Download this repository as a zip file"
                 rel="nofollow">
                <span class="octicon octicon-cloud-download"></span>
                Download ZIP
              </a>
            </div>
        </div><!-- /.repository-sidebar -->

        <div id="js-repo-pjax-container" class="repository-content context-loader-container" data-pjax-container>
          


<!-- blob contrib key: blob_contributors:v21:b166a840743e1883bc716737a800df08 -->

<p title="This is a placeholder element" class="js-history-link-replace hidden"></p>

<a href="/galaxiz/RPC/find/master" data-pjax data-hotkey="t" class="js-show-file-finder" style="display:none">Show File Finder</a>

<div class="file-navigation">
  
  

<div class="select-menu js-menu-container js-select-menu" >
  <span class="minibutton select-menu-button js-menu-target" data-hotkey="w"
    data-master-branch="master"
    data-ref="master"
    role="button" aria-label="Switch branches or tags" tabindex="0">
    <span class="octicon octicon-git-branch"></span>
    <i>branch:</i>
    <span class="js-select-button">master</span>
  </span>

  <div class="select-menu-modal-holder js-menu-content js-navigation-container" data-pjax>

    <div class="select-menu-modal">
      <div class="select-menu-header">
        <span class="select-menu-title">Switch branches/tags</span>
        <span class="octicon octicon-remove-close js-menu-close"></span>
      </div> <!-- /.select-menu-header -->

      <div class="select-menu-filters">
        <div class="select-menu-text-filter">
          <input type="text" aria-label="Find or create a branch…" id="context-commitish-filter-field" class="js-filterable-field js-navigation-enable" placeholder="Find or create a branch…">
        </div>
        <div class="select-menu-tabs">
          <ul>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="branches" class="js-select-menu-tab">Branches</a>
            </li>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="tags" class="js-select-menu-tab">Tags</a>
            </li>
          </ul>
        </div><!-- /.select-menu-tabs -->
      </div><!-- /.select-menu-filters -->

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="branches">

        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


            <div class="select-menu-item js-navigation-item selected">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <a href="/galaxiz/RPC/blob/master/src/rmiserver/RMIserver.java"
                 data-name="master"
                 data-skip-pjax="true"
                 rel="nofollow"
                 class="js-navigation-open select-menu-item-text js-select-button-text css-truncate-target"
                 title="master">master</a>
            </div> <!-- /.select-menu-item -->
        </div>

          <form accept-charset="UTF-8" action="/galaxiz/RPC/branches" class="js-create-branch select-menu-item select-menu-new-item-form js-navigation-item js-new-item-form" method="post"><div style="margin:0;padding:0;display:inline"><input name="authenticity_token" type="hidden" value="rDZoJF5heAR60s9+u0k2RH1YE1nuhg5CCt9MXh/MTTA=" /></div>
            <span class="octicon octicon-git-branch-create select-menu-item-icon"></span>
            <div class="select-menu-item-text">
              <h4>Create branch: <span class="js-new-item-name"></span></h4>
              <span class="description">from ‘master’</span>
            </div>
            <input type="hidden" name="name" id="name" class="js-new-item-value">
            <input type="hidden" name="branch" id="branch" value="master" />
            <input type="hidden" name="path" id="branch" value="src/rmiserver/RMIserver.java" />
          </form> <!-- /.select-menu-item -->

      </div> <!-- /.select-menu-list -->

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="tags">
        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


        </div>

        <div class="select-menu-no-results">Nothing to show</div>
      </div> <!-- /.select-menu-list -->

    </div> <!-- /.select-menu-modal -->
  </div> <!-- /.select-menu-modal-holder -->
</div> <!-- /.select-menu -->

  <div class="breadcrumb">
    <span class='repo-root js-repo-root'><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/galaxiz/RPC" data-branch="master" data-direction="back" data-pjax="true" itemscope="url"><span itemprop="title">RPC</span></a></span></span><span class="separator"> / </span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/galaxiz/RPC/tree/master/src" data-branch="master" data-direction="back" data-pjax="true" itemscope="url"><span itemprop="title">src</span></a></span><span class="separator"> / </span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/galaxiz/RPC/tree/master/src/rmiserver" data-branch="master" data-direction="back" data-pjax="true" itemscope="url"><span itemprop="title">rmiserver</span></a></span><span class="separator"> / </span><strong class="final-path">RMIserver.java</strong> <span class="js-zeroclipboard minibutton zeroclipboard-button" data-clipboard-text="src/rmiserver/RMIserver.java" data-copied-hint="copied!" title="copy to clipboard"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>


  <div class="commit commit-loader file-history-tease js-deferred-content" data-url="/galaxiz/RPC/contributors/master/src/rmiserver/RMIserver.java">
    Fetching contributors…

    <div class="participation">
      <p class="loader-loading"><img alt="Octocat-spinner-32-eaf2f5" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32-EAF2F5.gif" width="16" /></p>
      <p class="loader-error">Cannot retrieve contributors at this time</p>
    </div>
  </div>

<div id="files" class="bubble">
  <div class="file">
    <div class="meta">
      <div class="info">
        <span class="icon"><b class="octicon octicon-file-text"></b></span>
        <span class="mode" title="File Mode">file</span>
          <span>96 lines (82 sloc)</span>
        <span>2.26 kb</span>
      </div>
      <div class="actions">
        <div class="button-group">
                <a class="minibutton"
                   href="/galaxiz/RPC/edit/master/src/rmiserver/RMIserver.java"
                   data-method="post" rel="nofollow" data-hotkey="e">Edit</a>
          <a href="/galaxiz/RPC/raw/master/src/rmiserver/RMIserver.java" class="button minibutton " id="raw-url">Raw</a>
            <a href="/galaxiz/RPC/blame/master/src/rmiserver/RMIserver.java" class="button minibutton ">Blame</a>
          <a href="/galaxiz/RPC/commits/master/src/rmiserver/RMIserver.java" class="button minibutton " rel="nofollow">History</a>
        </div><!-- /.button-group -->
          <a class="minibutton danger empty-icon tooltipped downwards"
             href="/galaxiz/RPC/delete/master/src/rmiserver/RMIserver.java"
             title=""
             data-method="post" data-test-id="delete-blob-file" rel="nofollow">
          Delete
        </a>
      </div><!-- /.actions -->

    </div>
        <div class="blob-wrapper data type-java js-blob-data">
        <table class="file-code file-diff">
          <tr class="file-code-line">
            <td class="blob-line-nums">
              <span id="L1" rel="#L1">1</span>
<span id="L2" rel="#L2">2</span>
<span id="L3" rel="#L3">3</span>
<span id="L4" rel="#L4">4</span>
<span id="L5" rel="#L5">5</span>
<span id="L6" rel="#L6">6</span>
<span id="L7" rel="#L7">7</span>
<span id="L8" rel="#L8">8</span>
<span id="L9" rel="#L9">9</span>
<span id="L10" rel="#L10">10</span>
<span id="L11" rel="#L11">11</span>
<span id="L12" rel="#L12">12</span>
<span id="L13" rel="#L13">13</span>
<span id="L14" rel="#L14">14</span>
<span id="L15" rel="#L15">15</span>
<span id="L16" rel="#L16">16</span>
<span id="L17" rel="#L17">17</span>
<span id="L18" rel="#L18">18</span>
<span id="L19" rel="#L19">19</span>
<span id="L20" rel="#L20">20</span>
<span id="L21" rel="#L21">21</span>
<span id="L22" rel="#L22">22</span>
<span id="L23" rel="#L23">23</span>
<span id="L24" rel="#L24">24</span>
<span id="L25" rel="#L25">25</span>
<span id="L26" rel="#L26">26</span>
<span id="L27" rel="#L27">27</span>
<span id="L28" rel="#L28">28</span>
<span id="L29" rel="#L29">29</span>
<span id="L30" rel="#L30">30</span>
<span id="L31" rel="#L31">31</span>
<span id="L32" rel="#L32">32</span>
<span id="L33" rel="#L33">33</span>
<span id="L34" rel="#L34">34</span>
<span id="L35" rel="#L35">35</span>
<span id="L36" rel="#L36">36</span>
<span id="L37" rel="#L37">37</span>
<span id="L38" rel="#L38">38</span>
<span id="L39" rel="#L39">39</span>
<span id="L40" rel="#L40">40</span>
<span id="L41" rel="#L41">41</span>
<span id="L42" rel="#L42">42</span>
<span id="L43" rel="#L43">43</span>
<span id="L44" rel="#L44">44</span>
<span id="L45" rel="#L45">45</span>
<span id="L46" rel="#L46">46</span>
<span id="L47" rel="#L47">47</span>
<span id="L48" rel="#L48">48</span>
<span id="L49" rel="#L49">49</span>
<span id="L50" rel="#L50">50</span>
<span id="L51" rel="#L51">51</span>
<span id="L52" rel="#L52">52</span>
<span id="L53" rel="#L53">53</span>
<span id="L54" rel="#L54">54</span>
<span id="L55" rel="#L55">55</span>
<span id="L56" rel="#L56">56</span>
<span id="L57" rel="#L57">57</span>
<span id="L58" rel="#L58">58</span>
<span id="L59" rel="#L59">59</span>
<span id="L60" rel="#L60">60</span>
<span id="L61" rel="#L61">61</span>
<span id="L62" rel="#L62">62</span>
<span id="L63" rel="#L63">63</span>
<span id="L64" rel="#L64">64</span>
<span id="L65" rel="#L65">65</span>
<span id="L66" rel="#L66">66</span>
<span id="L67" rel="#L67">67</span>
<span id="L68" rel="#L68">68</span>
<span id="L69" rel="#L69">69</span>
<span id="L70" rel="#L70">70</span>
<span id="L71" rel="#L71">71</span>
<span id="L72" rel="#L72">72</span>
<span id="L73" rel="#L73">73</span>
<span id="L74" rel="#L74">74</span>
<span id="L75" rel="#L75">75</span>
<span id="L76" rel="#L76">76</span>
<span id="L77" rel="#L77">77</span>
<span id="L78" rel="#L78">78</span>
<span id="L79" rel="#L79">79</span>
<span id="L80" rel="#L80">80</span>
<span id="L81" rel="#L81">81</span>
<span id="L82" rel="#L82">82</span>
<span id="L83" rel="#L83">83</span>
<span id="L84" rel="#L84">84</span>
<span id="L85" rel="#L85">85</span>
<span id="L86" rel="#L86">86</span>
<span id="L87" rel="#L87">87</span>
<span id="L88" rel="#L88">88</span>
<span id="L89" rel="#L89">89</span>
<span id="L90" rel="#L90">90</span>
<span id="L91" rel="#L91">91</span>
<span id="L92" rel="#L92">92</span>
<span id="L93" rel="#L93">93</span>
<span id="L94" rel="#L94">94</span>
<span id="L95" rel="#L95">95</span>

            </td>
            <td class="blob-line-code">
                    <div class="highlight"><pre><div class='line' id='LC1'><span class="cm">/**</span></div><div class='line' id='LC2'><span class="cm"> * </span></div><div class='line' id='LC3'><span class="cm"> */</span></div><div class='line' id='LC4'><span class="kn">package</span> <span class="n">rmiserver</span><span class="o">;</span></div><div class='line' id='LC5'><br/></div><div class='line' id='LC6'><span class="kn">import</span> <span class="nn">java.net.Inet4Address</span><span class="o">;</span></div><div class='line' id='LC7'><span class="kn">import</span> <span class="nn">java.net.UnknownHostException</span><span class="o">;</span></div><div class='line' id='LC8'><br/></div><div class='line' id='LC9'><span class="kn">import</span> <span class="nn">registry.LocateRegistry</span><span class="o">;</span></div><div class='line' id='LC10'><span class="kn">import</span> <span class="nn">registry.Registry</span><span class="o">;</span></div><div class='line' id='LC11'><br/></div><div class='line' id='LC12'><span class="cm">/**</span></div><div class='line' id='LC13'><span class="cm"> * @author Shiwei Dong</span></div><div class='line' id='LC14'><span class="cm"> * </span></div><div class='line' id='LC15'><span class="cm"> *         RMI server responsible for register objects to registry and assign</span></div><div class='line' id='LC16'><span class="cm"> *         ports to remote objects</span></div><div class='line' id='LC17'><span class="cm"> * </span></div><div class='line' id='LC18'><span class="cm"> */</span></div><div class='line' id='LC19'><span class="kd">public</span> <span class="kd">class</span> <span class="nc">RMIserver</span> <span class="o">{</span></div><div class='line' id='LC20'><br/></div><div class='line' id='LC21'>	<span class="kd">private</span> <span class="n">String</span> <span class="n">prompt</span> <span class="o">=</span> <span class="s">&quot;Server&quot;</span><span class="o">;</span></div><div class='line' id='LC22'>	<span class="kd">private</span> <span class="n">String</span> <span class="n">hostServerIP</span><span class="o">;</span></div><div class='line' id='LC23'><br/></div><div class='line' id='LC24'>	<span class="kd">public</span> <span class="nf">RMIserver</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC25'>		<span class="k">try</span> <span class="o">{</span></div><div class='line' id='LC26'>			<span class="n">hostServerIP</span> <span class="o">=</span> <span class="n">Inet4Address</span><span class="o">.</span><span class="na">getLocalHost</span><span class="o">().</span><span class="na">getHostAddress</span><span class="o">();</span></div><div class='line' id='LC27'>			<span class="n">prompt</span> <span class="o">=</span> <span class="n">prompt</span> <span class="o">+</span> <span class="s">&quot;@&quot;</span> <span class="o">+</span> <span class="n">hostServerIP</span> <span class="o">+</span> <span class="s">&quot;&gt;&quot;</span><span class="o">;</span></div><div class='line' id='LC28'>		<span class="o">}</span> <span class="k">catch</span> <span class="o">(</span><span class="n">UnknownHostException</span> <span class="n">e</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC29'>			<span class="c1">// TODO Auto-generated catch block</span></div><div class='line' id='LC30'>			<span class="n">e</span><span class="o">.</span><span class="na">printStackTrace</span><span class="o">();</span></div><div class='line' id='LC31'>		<span class="o">}</span></div><div class='line' id='LC32'>	<span class="o">}</span></div><div class='line' id='LC33'><br/></div><div class='line' id='LC34'>	<span class="kd">public</span> <span class="kt">void</span> <span class="nf">printUsage</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC35'>		<span class="n">StringBuilder</span> <span class="n">usage</span> <span class="o">=</span> <span class="k">new</span> <span class="n">StringBuilder</span><span class="o">();</span></div><div class='line' id='LC36'>		<span class="n">usage</span><span class="o">.</span><span class="na">append</span><span class="o">(</span><span class="s">&quot;Usage:\n&quot;</span><span class="o">);</span></div><div class='line' id='LC37'>		<span class="n">usage</span><span class="o">.</span><span class="na">append</span><span class="o">(</span><span class="s">&quot;register &lt;server_class_name(without.class)&gt; ... Register a server class\n&quot;</span><span class="o">);</span></div><div class='line' id='LC38'>		<span class="n">usage</span><span class="o">.</span><span class="na">append</span><span class="o">(</span><span class="s">&quot;exit ... Exit the server\n&quot;</span><span class="o">);</span></div><div class='line' id='LC39'>		<span class="n">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">print</span><span class="o">(</span><span class="n">usage</span><span class="o">);</span></div><div class='line' id='LC40'>	<span class="o">}</span></div><div class='line' id='LC41'><br/></div><div class='line' id='LC42'>	<span class="cm">/**</span></div><div class='line' id='LC43'><span class="cm">	 * @return the prompt</span></div><div class='line' id='LC44'><span class="cm">	 */</span></div><div class='line' id='LC45'>	<span class="kd">public</span> <span class="n">String</span> <span class="nf">getPrompt</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC46'>		<span class="k">return</span> <span class="n">prompt</span><span class="o">;</span></div><div class='line' id='LC47'>	<span class="o">}</span></div><div class='line' id='LC48'><br/></div><div class='line' id='LC49'>	<span class="cm">/**</span></div><div class='line' id='LC50'><span class="cm">	 * Oct 9, 2013</span></div><div class='line' id='LC51'><span class="cm">	 * </span></div><div class='line' id='LC52'><span class="cm">	 * Arguments are Registry port and Registry host Connect to the Registry use</span></div><div class='line' id='LC53'><span class="cm">	 * LocateRegistry.getRegistry(host,port) Every time a new user server</span></div><div class='line' id='LC54'><span class="cm">	 * program register, Initialize a stub Rebind the service name and the stub,</span></div><div class='line' id='LC55'><span class="cm">	 * </span></div><div class='line' id='LC56'><span class="cm">	 * @param args</span></div><div class='line' id='LC57'><span class="cm">	 * </span></div><div class='line' id='LC58'><span class="cm">	 */</span></div><div class='line' id='LC59'>	<span class="kd">public</span> <span class="kd">static</span> <span class="kt">void</span> <span class="nf">main</span><span class="o">(</span><span class="n">String</span><span class="o">[]</span> <span class="n">args</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC60'><br/></div><div class='line' id='LC61'>		<span class="n">RMIserver</span> <span class="n">myserver</span> <span class="o">=</span> <span class="k">new</span> <span class="n">RMIserver</span><span class="o">();</span></div><div class='line' id='LC62'><br/></div><div class='line' id='LC63'>		<span class="k">try</span> <span class="o">{</span></div><div class='line' id='LC64'>			<span class="n">Registry</span> <span class="n">registry</span><span class="o">;</span></div><div class='line' id='LC65'>			<span class="n">registry</span> <span class="o">=</span> <span class="n">LocateRegistry</span><span class="o">.</span><span class="na">getRegistry</span><span class="o">(</span><span class="n">Inet4Address</span><span class="o">.</span><span class="na">getLocalHost</span><span class="o">()</span></div><div class='line' id='LC66'>					<span class="o">.</span><span class="na">getHostAddress</span><span class="o">(),</span> <span class="mi">1099</span><span class="o">);</span></div><div class='line' id='LC67'><br/></div><div class='line' id='LC68'>			<span class="k">while</span> <span class="o">(</span><span class="kc">true</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC69'>				<span class="n">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">print</span><span class="o">(</span><span class="n">myserver</span><span class="o">.</span><span class="na">getPrompt</span><span class="o">());</span></div><div class='line' id='LC70'>				<span class="n">String</span> <span class="n">cmdl</span> <span class="o">=</span> <span class="n">System</span><span class="o">.</span><span class="na">console</span><span class="o">().</span><span class="na">readLine</span><span class="o">();</span></div><div class='line' id='LC71'>				<span class="n">String</span> <span class="n">cmdargs</span><span class="o">[]</span> <span class="o">=</span> <span class="n">cmdl</span><span class="o">.</span><span class="na">split</span><span class="o">(</span><span class="s">&quot; &quot;</span><span class="o">);</span></div><div class='line' id='LC72'>				<span class="k">if</span> <span class="o">(</span><span class="n">cmdargs</span><span class="o">[</span><span class="mi">0</span><span class="o">].</span><span class="na">equals</span><span class="o">(</span><span class="s">&quot;register&quot;</span><span class="o">))</span> <span class="o">{</span></div><div class='line' id='LC73'>					<span class="n">String</span> <span class="n">class_name</span> <span class="o">=</span> <span class="n">cmdargs</span><span class="o">[</span><span class="mi">1</span><span class="o">];</span></div><div class='line' id='LC74'>					<span class="n">String</span> <span class="n">class_stub_name</span> <span class="o">=</span> <span class="n">cmdargs</span><span class="o">[</span><span class="mi">1</span><span class="o">]</span> <span class="o">+</span> <span class="s">&quot;_stub&quot;</span><span class="o">;</span></div><div class='line' id='LC75'>					<span class="c1">// start a new thread to handle this particular server</span></div><div class='line' id='LC76'>					<span class="c1">// object</span></div><div class='line' id='LC77'>					<span class="n">Runnable</span> <span class="n">job</span> <span class="o">=</span> <span class="k">new</span> <span class="n">Server_handler</span><span class="o">(</span><span class="n">registry</span><span class="o">,</span> <span class="n">class_name</span><span class="o">,</span></div><div class='line' id='LC78'>							<span class="n">class_stub_name</span><span class="o">);</span></div><div class='line' id='LC79'>					<span class="n">Thread</span> <span class="n">t</span> <span class="o">=</span> <span class="k">new</span> <span class="n">Thread</span><span class="o">(</span><span class="n">job</span><span class="o">);</span></div><div class='line' id='LC80'>					<span class="n">t</span><span class="o">.</span><span class="na">start</span><span class="o">();</span></div><div class='line' id='LC81'>				<span class="o">}</span> <span class="k">else</span> <span class="k">if</span> <span class="o">(</span><span class="n">cmdargs</span><span class="o">[</span><span class="mi">0</span><span class="o">].</span><span class="na">equals</span><span class="o">(</span><span class="s">&quot;exit&quot;</span><span class="o">))</span> <span class="o">{</span></div><div class='line' id='LC82'>					<span class="n">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="s">&quot;Server Exisiting...&quot;</span><span class="o">);</span></div><div class='line' id='LC83'>					<span class="k">break</span><span class="o">;</span></div><div class='line' id='LC84'>				<span class="o">}</span> <span class="k">else</span> <span class="o">{</span></div><div class='line' id='LC85'>					<span class="n">myserver</span><span class="o">.</span><span class="na">printUsage</span><span class="o">();</span></div><div class='line' id='LC86'>				<span class="o">}</span></div><div class='line' id='LC87'>			<span class="o">}</span></div><div class='line' id='LC88'><br/></div><div class='line' id='LC89'>		<span class="o">}</span> <span class="k">catch</span> <span class="o">(</span><span class="n">UnknownHostException</span> <span class="n">e</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC90'>			<span class="c1">// TODO Auto-generated catch block</span></div><div class='line' id='LC91'>			<span class="n">e</span><span class="o">.</span><span class="na">printStackTrace</span><span class="o">();</span></div><div class='line' id='LC92'>		<span class="o">}</span></div><div class='line' id='LC93'>	<span class="o">}</span></div><div class='line' id='LC94'><br/></div><div class='line' id='LC95'><span class="o">}</span></div></pre></div>
            </td>
          </tr>
        </table>
  </div>

  </div>
</div>

<a href="#jump-to-line" rel="facebox[.linejump]" data-hotkey="l" class="js-jump-to-line" style="display:none">Jump to Line</a>
<div id="jump-to-line" style="display:none">
  <form accept-charset="UTF-8" class="js-jump-to-line-form">
    <input class="linejump-input js-jump-to-line-field" type="text" placeholder="Jump to line&hellip;" autofocus>
    <button type="submit" class="button">Go</button>
  </form>
</div>

        </div>

      </div><!-- /.repo-container -->
      <div class="modal-backdrop"></div>
    </div><!-- /.container -->
  </div><!-- /.site -->


    </div><!-- /.wrapper -->

      <div class="container">
  <div class="site-footer">
    <ul class="site-footer-links right">
      <li><a href="https://status.github.com/">Status</a></li>
      <li><a href="http://developer.github.com">API</a></li>
      <li><a href="http://training.github.com">Training</a></li>
      <li><a href="http://shop.github.com">Shop</a></li>
      <li><a href="/blog">Blog</a></li>
      <li><a href="/about">About</a></li>

    </ul>

    <a href="/">
      <span class="mega-octicon octicon-mark-github"></span>
    </a>

    <ul class="site-footer-links">
      <li>&copy; 2013 <span title="0.07122s from github-fe132-cp1-prd.iad.github.net">GitHub</span>, Inc.</li>
        <li><a href="/site/terms">Terms</a></li>
        <li><a href="/site/privacy">Privacy</a></li>
        <li><a href="/security">Security</a></li>
        <li><a href="/contact">Contact</a></li>
    </ul>
  </div><!-- /.site-footer -->
</div><!-- /.container -->


    <div class="fullscreen-overlay js-fullscreen-overlay" id="fullscreen_overlay">
  <div class="fullscreen-container js-fullscreen-container">
    <div class="textarea-wrap">
      <textarea name="fullscreen-contents" id="fullscreen-contents" class="js-fullscreen-contents" placeholder="" data-suggester="fullscreen_suggester"></textarea>
          <div class="suggester-container">
              <div class="suggester fullscreen-suggester js-navigation-container" id="fullscreen_suggester"
                 data-url="/galaxiz/RPC/suggestions/commit">
              </div>
          </div>
    </div>
  </div>
  <div class="fullscreen-sidebar">
    <a href="#" class="exit-fullscreen js-exit-fullscreen tooltipped leftwards" title="Exit Zen Mode">
      <span class="mega-octicon octicon-screen-normal"></span>
    </a>
    <a href="#" class="theme-switcher js-theme-switcher tooltipped leftwards"
      title="Switch themes">
      <span class="octicon octicon-color-mode"></span>
    </a>
  </div>
</div>



    <div id="ajax-error-message" class="flash flash-error">
      <span class="octicon octicon-alert"></span>
      <a href="#" class="octicon octicon-remove-close close ajax-error-dismiss"></a>
      Something went wrong with that request. Please try again.
    </div>

  </body>
</html>


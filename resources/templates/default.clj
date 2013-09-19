;;(doctype :xhtml-transitional)
[:html
 {:xmlns "http://www.w3.org/1999/xhtml" :lang "en" :xml:lang "en"}
 [:head
  [:meta {:http-equiv "content-type" :content "text/html; charset=UTF-8"}]
  [:meta {:name "description" :content (:description metadata)}]
  [:meta {:name "keywords" :content (:tags metadata)}]
  [:meta {:name "author" :content "Lei Wang"}]
  [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
  [:link {:rel "icon" :href "/images/favicon.ico" :type "image/x-icon"}]
  [:link {:rel "shortcut icon" :href "/images/favicon.ico" :type "image/x-icon"}]
  [:link {:rel "stylesheet" :type "text/css" :href "//cdnjs.cloudflare.com/ajax/libs/font-awesome/3.2.1/css/font-awesome.min.css"}]
  [:link {:rel "stylesheet" :type "text/css" :href "//fonts.googleapis.com/css?family=Source+Code+Pro|Open+Sans"}]
  [:link {:rel "stylesheet" :type "text/css" :href "/css/bootstrap.min.css"}]
  [:link {:rel "stylesheet" :type "text/css" :href "/css/customization.css"}]
  [:title (:title metadata)]]
 [:body
  [:div.header
   [:nav.navbar.navbar-default.navbar-fixed-top {:role "navigation"}
    [:div.container
     [:div.navbar-header
      [:button.navbar-toggle {:type "button" :data-toggle "collapse" :data-target ".navbar-ex1-collapse"}
      [:span.sr-only "Toggle navigation"]
      [:span.icon-bar]
      [:span.icon-bar]
      [:span.icon-bar]]
      [:a.navbar-brand {:href "/index.html"} "Lei Wang"]
      ]
     [:div.collapse.navbar-collapse.navbar-ex1-collapse
      [:ul.nav.navbar-nav
       [:li [:a {:href "/blog.html"} "Blog"]]
       ;; [:li [:a {:href "/projects.html"} "Projects"]]
       ;; [:li [:a {:href "/about.html"} "About"]]
       ]
      [:ul.nav.navbar-nav.navbar-right
       [:li [:a.icon-header {:href "http://github.com/tendant"} [:i.icon-github.icon-2x]]
       [:li [:a.icon-header {:href "http://twitter.com/tendant"} [:i.icon-twitter.icon-2x]]
        ]]]]]]]
  [:div.content
   [:div.container
    [:div.row
     [:div.col-md-12
      content
      (if (= (:type metadata) :post)
        [:div.shares
         [:a.twitter-share-button {:href "https://twitter.com/share" :data-via "tendant"} "Tweet"]]
        [:br]
        [:div#disqus_thread])]]
    ;; content
    
    [:script {:src "//cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"}]
    [:script {:src "//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.0-rc2/js/bootstrap.min.js"}]
    [:script {:src "//google-code-prettify.googlecode.com/svn/loader/run_prettify.js"}]
    [:script {:src "//google-code-prettify.googlecode.com/svn/trunk/src/lang-clj.js"}]
    ]]
  [:div.footer
   [:div.container
    [:div.row
     [:div.col-md-12
      [:p "Built with "
       [:a {:href "http://getbootstrap.com/"} "Bootstrap"] " and "
       [:a {:href "https://github.com/nakkaya/static"} "Static"]
       [:a
        {:href "http://creativecommons.org/licenses/by-sa/3.0/deed.en_US",
         :rel "license"}
        [:img
         {:src "http://i.creativecommons.org/l/by-sa/3.0/88x31.png",
          :style "border-width:0",
          :alt "Creative Commons License"}]]
       [:br]
       "This work by "
       [:a
        {:rel "cc:attributionURL",
         :property "cc:attributionName",
         :href "blog.leiwang.info"}
        "blog.leiwang.info"]
       " is licensed under a "
       [:a
        {:href "http://creativecommons.org/licenses/by-sa/3.0/deed.en_US",
         :rel "license"}
        "Creative Commons Attribution-ShareAlike 3.0 Unported License"]
       ".\n"]]]]]]]
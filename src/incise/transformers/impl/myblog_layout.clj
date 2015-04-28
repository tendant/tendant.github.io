(ns incise.transformers.impl.myblog-layout
  (:require (incise.transformers [core :refer [register]]
                                 [layout :refer [render-content
                                                 deflayout
                                                 defpartial]])
            [clojure.string :as s]
            [incise.config :as conf]
            (hiccup [core :refer :all]
                    [util :refer [with-base-url]]
                    [def :refer :all]
                    [page :refer :all]
                    [element :refer :all]))
  (:import [java.io FileNotFoundException]))

(defn stylesheets []
  ["/assets/css/bootstrap.min.css"
   "/assets/css/customization.css"])

(defn javascripts [] [])

(defpartial head
  "The default head."
  [{:keys [site-title]} {:keys [title]}]
  [:head
   (when (or site-title title)
     [:title (s/join " - " (keep identity [site-title title]))])
   [:meta {:charset "UTF-8"}]
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
   (apply include-css (keep identity (stylesheets)))])

(defpartial header "A blank header"
  []
  [:div.header
   [:nav.navbar.navbar-default.navbar-static-top {:role "navigation"}
    [:div.container
     [:div.navbar-header
      [:button.navbar-toggle {:type "button" :data-toggle "collapse" :data-target ".navbar-ex1-collapse"}
      [:span.sr-only "Toggle navigation"]
      [:span.icon-bar]
      [:span.icon-bar]
      [:span.icon-bar]]
      [:a.navbar-brand {:href "#"} "Lei Wang"]
      ]
     [:div.collapse.navbar-collapse.navbar-ex1-collapse
      [:ul.nav.navbar-nav
       ;; [:li [:a {:href "/blog.html"} "Blog"]]
       ;; [:li [:a {:href "/projects.html"} "Projects"]]
       ;; [:li [:a {:href "/about.html"} "About"]]
       ]
      [:ul.nav.navbar-nav.navbar-right
       [:li [:a.icon-header {:href "http://github.com/tendant"} [:i.icon-github.icon-2x]]
       [:li [:a.icon-header {:href "http://twitter.com/tendant"} [:i.icon-twitter.icon-2x]]
        ]]]]]]])

(defpartial content
  "A very basic content partial."
  [_ {:keys [content]}]
  [:div.container
   [:div.row
    [:div.col-md-12
     (render-content content)]]])

(defpartial footer
  "A very basic footer crediting this project."
  [{:keys [contacts author]} _]
  [:footer
   [:p
    ""]])

(deflayout base
  "The default page/post layout."
  []
  (with-base-url (when-not (conf/serving?) (str \/ (conf/get :uri-root)))
    (html5
     (head)
     [:body#page
      (header)
      [:div#content [:article (content)]]
      (footer)
      (apply include-js (remove nil? (javascripts)))])))

(register :myblog-layout base)

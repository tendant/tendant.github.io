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

(defn stylesheets [] [])

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

(defpartial header "A blank header" [] nil)

(defpartial content
  "A very basic content partial."
  [_ {:keys [content]}]
  (render-content content))

(defpartial footer
  "A very basic footer crediting this project."
  [{:keys [contacts author]} _]
  [:footer
   [:p
    "This website was "
    (link-to "https://github.com/RyanMcG/incise" "incised") \.]])

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

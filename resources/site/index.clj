{:title "blog.leiwang.info"}

[:div
 [:div.row
  [:div.col-md-12
   [:h1 "[untitled]"]]]
 [:div.row
  [:div.col-md-6
   [:p.lead.text-muted
    "Random thoughts"]]]
 [:div.row
  [:div.col-md-12
   [:p
    ]
   [:p
    ]]]
 [:br]
 [:div.row
  [:div.col-md-6
   [:h4 "Recent Blog Posts"]
   (map #(let [f % url (static.core/post-url f)
               [metadata _] (static.io/read-doc f)
               date (static.core/parse-date
                     "yyyy-MM-dd" "dd MMMM yyyy"
                     (re-find #"\d*-\d*-\d*" (str f)))]
      [:div
       [:div [:a {:href url} (:title metadata)]
       [:div date]]])
      (take 8 (reverse (static.io/list-files :posts))))]
    [:div.col-md-6
    [:h4 "Recent Activity on Github"]
    [:div.gh-recent]]]]

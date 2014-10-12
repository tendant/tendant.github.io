{:title "blog.leiwang.info"}

[:div
 [:div.row
  [:div.col-md-12
   [:h2 "Blog"]
   [:ul 
    (map #(let [f % url (static.core/post-url f)
                [metadata _] (static.io/read-doc f)
                date (static.core/parse-date
                      "yyyy-MM-dd" "dd MMM yyyy"
                      (re-find #"\d*-\d*-\d*" (str f)))]
            [:li.blog-title (list [:a {:href url} (:title metadata)] [:span date])])
         (take 8 (reverse (static.io/list-files :posts))))]
   ]]]

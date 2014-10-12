{:title "blog.leiwang.info"}

[:div
 [:div.row
  [:div.col-md-12
   [:h2 "Blog"]
   (map #(let [f % url (static.core/post-url f)
               [metadata _] (static.io/read-doc f)
               date (static.core/parse-date
                     "yyyy-MM-dd" "dd MMM yyyy"
                     (re-find #"\d*-\d*-\d*" (str f)))]
      [:ul
       [:li.blog-title [:a {:href url} (:title metadata)]] date])
      (take 8 (reverse (static.io/list-files :posts))))
   ]]]

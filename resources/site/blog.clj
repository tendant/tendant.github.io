{:title "blog.leiwang.info - Blog"}

[:div
 [:div.row
  [:div.col-md-12
   [:h2 "Blog"]
   (map #(let [f % url (static.core/post-url f)
               [metadata _] (static.io/read-doc f)
               date (static.core/parse-date
                     "yyyy-MM-dd" "dd MMM yyyy"
                     (re-find #"\d*-\d*-\d*" (str f)))]
      [:div
       [:h5.blog-title [:a {:href url} (:title metadata)]]
       [:h6.blog-date date]])
      (take 8 (reverse (static.io/list-files :posts))))
   ]]]

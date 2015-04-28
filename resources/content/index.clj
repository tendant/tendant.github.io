{:transformers [:myblog-layout]}

(require '[hiccup.core :refer [html]])

(println parses)

(defn post [{:keys [title] :as parse}]
  [:p title])

(html [:ul.posts
       (->> parses
            (map post))])

(defproject my-blog "1.0.0-SNAPSHOT"
  :description "A very basic blog"
  :url "http://leiwang.info/blog"
  :license {:name "CC"
            :url "http://creativecommons.org/licenses/by/4.0/"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [incise "0.5.0"]]
  
  :aliases {"incise" ^:pass-through-help ["run" "-m" "incise.core"]}
  :main incise.core)

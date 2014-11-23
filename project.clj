(defproject reagent-components-example "0.1.0-SNAPSHOT"
  :description ""
  :url "https://github.com/meta-x/reagent-components-example"
  :license {
    :name "The MIT License"
    :url "http://opensource.org/licenses/MIT"
  }

  :dependencies [
    [org.clojure/clojure "1.6.0"]
    [org.clojure/clojurescript "0.0-2311"]
    [reagent "0.4.3"]
    [meta-x/reagent-components "0.1.0"]]

  :plugins [[lein-cljsbuild "1.0.4-SNAPSHOT"]]

  :source-paths ["src"]

  :cljsbuild {
    :builds {
      :prod {
        :source-paths ["src/"]
        :compiler {
          :output-to "reagent_components_example.js"
          :optimizations :advanced
          :elide-asserts true
          :pretty-print false
          :output-wrapper false
        }
      }
    }
  }
)
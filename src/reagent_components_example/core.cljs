(ns reagent-components-example.core
  (:require [reagent.core :refer [atom render-component]]
            [reagent-components.core :refer [text-input async-btn]]))

(enable-console-print!)

(defn example-text-input []
  (let [ra-val (atom nil)]
    (fn []
      [text-input
        {}
        ra-val
        #(println "<enter> was pressed. input value is" @ra-val)
        ])))

(defn example-async-btn1 []
  [async-btn
    {:class-waiting "fa fa-spinner fa-spin"}
    [:span "click with no reset"]
    (fn [ra-waiting]
      (println @ra-waiting)
      (println "clicked but not reset"))])

(defn example-async-btn2 []
  [async-btn
    {:class-waiting "fa fa-spinner fa-spin"}
    [:span "click with reset"]
    (fn [ra-waiting]
      (println @ra-waiting)
      (println "clicked and reset (after 1 sec)")
      (js/setTimeout #(reset! ra-waiting false) 1000))])


(render-component
  [:div
    [example-text-input]
    [example-async-btn1]
    [example-async-btn2]]
  (. js/document (getElementById "root")))

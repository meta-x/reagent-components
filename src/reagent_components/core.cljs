(ns reagent-components.core
  (:require [reagent.core :refer [atom dom-node create-class render-component]]))

(defn text-input [attrs ra-value & [on-key-down]]
  (create-class {
    :component-did-mount (fn [this]
      (.focus (dom-node this)))
    :render (fn [this]
      [:input
        (merge
          {:type :text :value @ra-value :on-change #(reset! ra-value (-> % .-target .-value))
           :on-key-down #(when (and (not (nil? on-key-down)) (= (.-keyCode %) 13)) (on-key-down))}
          attrs)])}))

(defn async-btn [attrs content fn-async]
  (let [ra-waiting (atom false)]
    (fn [attrs content fn-async]
      [:button
        (merge
          {:on-click (fn [evt] (reset! ra-waiting true) (fn-async ra-waiting))
           (if @ra-waiting :disabled :enabled) :true}
          attrs)
        (if @ra-waiting
          [:i.waiting {:class (:class-waiting attrs)}]
          content)])))

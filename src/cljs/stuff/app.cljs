(ns stuff.app
  (:require [reagent.core :as reagent :refer [atom]]
            ;; [thereisnodot.reagent-autocomplete.core :as autocomplete]
            [stuff.data :refer [countries]]
            [stuff.core :as autocomplete]))

(defn some-component []
  [:div 
   [:div {:style {:width "100%"}}
    [autocomplete/autocomplete_widget
     countries
     {:can-enter-new? false
      :display-size 5
      :placeholder "Enter any city"
      :submit-fn
      (fn [item]
        (.log js/console "Submitted: " item))}]]])

(defn calling-component []
  [some-component])

(defn init []
  (reagent/render-component [calling-component]
                            (.getElementById js/document "container")))

(ns tetris.ui)

(defn create-element [kind props & children]
  (apply js/React.createElement kind (clj->js props) children))

(defn Cell []
  (let [[class-name set-class-name] (js/React.useState "matrix--cell")]
    (create-element "div" {:className class-name :onClick #(set-class-name "matrix--block")})))

(defn Matrix []
  (create-element
    "div"
    {:className "matrix"}
    (map
      (fn [row] (map #(create-element Cell {:key (str row %)}) (range 10)))
      (range 20))))

(js/ReactDOM.render
  (create-element Matrix nil)
  (js/document.getElementById "app"))

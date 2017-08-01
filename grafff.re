let graph = ref [];

let edge a b g => List.append [[a, b]] g;

graph := edge 3 4 graph.contents;

graph := edge 4 5 graph.contents;

graph := edge 5 9 graph.contents;

graph := edge 9 1 graph.contents;

graph := edge 1 3 graph.contents;

graph := edge 5 8 graph.contents;

let filterFrom x pair =>
  switch pair {
  | [] => false
  | [a, b] => a === x
  | [a, b, ...rest] => false
  };

let filterTo x pair =>
  switch pair {
  | [] => false
  | [a, b] => b === x
  | [a, b, ...rest] => false
  };

let fromVerticle x g => List.filter (filterFrom x) g |> List.map (fun [a, b] => b);

let toVerticle x g => List.filter (filterTo x) g |> List.map (fun [a, b] => a);

let gg = Hashtbl.create;
